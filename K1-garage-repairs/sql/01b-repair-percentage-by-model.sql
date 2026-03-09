-- Question b: Percentage of repairs by model (single row result)
SELECT 
    ROUND(100.0 * SUM(CASE WHEN modele = 'RANGER' THEN 1 ELSE 0 END) / COUNT(*), 2) AS nbre_reparation_ranger,
    ROUND(100.0 * SUM(CASE WHEN modele = 'EVEREST' THEN 1 ELSE 0 END) / COUNT(*), 2) AS nbre_reparation_everest,
    ROUND(100.0 * SUM(CASE WHEN modele = 'YUKON' THEN 1 ELSE 0 END) / COUNT(*), 2) AS nbre_reparation_yukon,
    ROUND(100.0 * SUM(CASE WHEN modele = 'RAM' THEN 1 ELSE 0 END) / COUNT(*), 2) AS nbre_reparation_ram
FROM Modele_voiture mv
JOIN Reparation r ON mv.id = r.id_modele_voiture;