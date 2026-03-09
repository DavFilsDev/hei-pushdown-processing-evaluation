import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class GarageRepository {
    
    private final JdbcTemplate jdbcTemplate;
    
    public GarageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    // Query 1a: Number of repairs by brand and model
    public List<RepairStatistics> getRepairCountByBrandAndModel() {
        String sql = """
            SELECT 
                mv.marque AS brand,
                mv.modele AS model,
                COUNT(r.id) AS repairCount
            FROM Modele_voiture mv
            LEFT JOIN Reparation r ON mv.id = r.id_modele_voiture
            GROUP BY mv.marque, mv.modele
            ORDER BY mv.marque, mv.modele
            """;
        
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            RepairStatistics stats = new RepairStatistics();
            stats.setBrand(rs.getString("brand"));
            stats.setModel(rs.getString("model"));
            stats.setRepairCount(rs.getInt("repairCount"));
            return stats;
        });
    }
    
    // Query 1b: Percentage of repairs by model
    public RepairStatistics getRepairPercentages() {
        String sql = """
            SELECT 
                ROUND(100.0 * SUM(CASE WHEN modele = 'RANGER' THEN 1 ELSE 0 END) / COUNT(*), 2) AS ranger_pct,
                ROUND(100.0 * SUM(CASE WHEN modele = 'EVEREST' THEN 1 ELSE 0 END) / COUNT(*), 2) AS everest_pct,
                ROUND(100.0 * SUM(CASE WHEN modele = 'YUKON' THEN 1 ELSE 0 END) / COUNT(*), 2) AS yukon_pct,
                ROUND(100.0 * SUM(CASE WHEN modele = 'RAM' THEN 1 ELSE 0 END) / COUNT(*), 2) AS ram_pct
            FROM Modele_voiture mv
            JOIN Reparation r ON mv.id = r.id_modele_voiture
            """;
        
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            RepairStatistics stats = new RepairStatistics();
            stats.setRangerPercentage(rs.getDouble("ranger_pct"));
            stats.setEverestPercentage(rs.getDouble("everest_pct"));
            stats.setYukonPercentage(rs.getDouble("yukon_pct"));
            stats.setRamPercentage(rs.getDouble("ram_pct"));
            return stats;
        });
    }
    
    // Query 1c: Repair cost by brand and mechanic
    public List<RepairStatistics> getRepairCostByBrandAndMechanic() {
        String sql = """
            SELECT 
                mv.marque AS brand,
                m.nom AS mechanicName,
                COALESCE(SUM(r.cout), 0) AS totalCost
            FROM Modele_voiture mv
            CROSS JOIN Mecanicien m
            LEFT JOIN Reparation r ON m.id = r.id_mecanicien AND mv.id = r.id_modele_voiture
            GROUP BY mv.marque, m.nom, m.id
            ORDER BY mv.marque, m.nom
            """;
        
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            RepairStatistics stats = new RepairStatistics();
            stats.setBrand(rs.getString("brand"));
            stats.setMechanicName(rs.getString("mechanicName"));
            stats.setTotalCost(rs.getBigDecimal("totalCost"));
            return stats;
        });
    }
    
    // Query 1d: Mechanic with lowest revenue
    public RepairStatistics getLowestRevenueMechanic() {
        String sql = """
            SELECT 
                m.nom AS mechanicName,
                COALESCE(SUM(r.cout), 0) AS totalCost
            FROM Mecanicien m
            LEFT JOIN Reparation r ON m.id = r.id_mecanicien
            GROUP BY m.id, m.nom
            ORDER BY totalCost ASC
            LIMIT 1
            """;
        
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            RepairStatistics stats = new RepairStatistics();
            stats.setLowestRevenueMechanic(rs.getString("mechanicName"));
            stats.setLowestRevenue(rs.getBigDecimal("totalCost"));
            return stats;
        });
    }
}