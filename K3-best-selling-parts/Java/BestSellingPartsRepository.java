package com.hei.k3;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class BestSellingPartsRepository {
    
    private final JdbcTemplate jdbcTemplate;
    
    public BestSellingPartsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    // Query 3a: Parts sold by brand and model
    public List<VehicleTrajet> getPartsSoldByBrandAndModel() {
        String sql = """
            SELECT 
                mv.marque AS brand,
                mv.modele AS model,
                COALESCE(SUM(v.quantite), 0) AS partsSold
            FROM Modele_voiture mv
            LEFT JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
            LEFT JOIN Vente v ON pa.id = v.id_piece_auto
            GROUP BY mv.marque, mv.modele
            ORDER BY mv.marque, mv.modele
            """;
        
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VehicleTrajet vt = new VehicleTrajet();
            vt.setBrand(rs.getString("brand"));
            vt.setModel(rs.getString("model"));
            vt.setPartsSold(rs.getInt("partsSold"));
            return vt;
        });
    }
    
    // Query 3b: Parts sold by brand (single row)
    public VehicleTrajet getPartsSoldByBrand() {
        String sql = """
            SELECT 
                COALESCE(SUM(CASE WHEN mv.marque = 'KIA' THEN v.quantite ELSE 0 END), 0) AS kiaPartsCount,
                COALESCE(SUM(CASE WHEN mv.marque = 'DAEWOO' THEN v.quantite ELSE 0 END), 0) AS daewooPartsCount
            FROM Modele_voiture mv
            LEFT JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
            LEFT JOIN Vente v ON pa.id = v.id_piece_auto
            """;
        
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            VehicleTrajet vt = new VehicleTrajet();
            vt.setKiaPartsCount(rs.getInt("kiaPartsCount"));
            vt.setDaewooPartsCount(rs.getInt("daewooPartsCount"));
            return vt;
        });
    }
    
    // Query 3c: Sales percentage by brand before date
    public List<VehicleTrajet> getSalesPercentageBeforeDate() {
        String sql = """
            SELECT 
                mv.marque AS saleBrand,
                ROUND(100.0 * SUM(v.quantite) / total.total_quantite, 2) AS percentage
            FROM Modele_voiture mv
            JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
            JOIN Vente v ON pa.id = v.id_piece_auto
            CROSS JOIN (
                SELECT SUM(quantite) AS total_quantite
                FROM Vente
                WHERE date < '2026-01-01'
            ) total
            WHERE v.date < '2026-01-01'
            GROUP BY mv.marque, total.total_quantite
            """;
        
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VehicleTrajet vt = new VehicleTrajet();
            vt.setSaleBrand(rs.getString("saleBrand"));
            vt.setPercentage(rs.getBigDecimal("percentage"));
            return vt;
        });
    }
    
    // Alternative implementation using the template from the exam
    public List<VehicleTrajet> findVehicleTrajets() {
        List<VehicleTrajet> list = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 """
                 SELECT 
                     mv.marque AS brand,
                     mv.modele AS model,
                     COALESCE(SUM(v.quantite), 0) AS partsSold
                 FROM Modele_voiture mv
                 LEFT JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
                 LEFT JOIN Vente v ON pa.id = v.id_piece_auto
                 GROUP BY mv.marque, mv.modele
                 ORDER BY mv.marque, mv.modele
                 """
             );
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                VehicleTrajet vehicleTrajet = new VehicleTrajet();
                vehicleTrajet.setBrand(resultSet.getString("brand"));
                vehicleTrajet.setModel(resultSet.getString("model"));
                vehicleTrajet.setPartsSold(resultSet.getInt("partsSold"));
                list.add(vehicleTrajet);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}