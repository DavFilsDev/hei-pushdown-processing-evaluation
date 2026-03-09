-- Question a: Number of repairs by car brand and model
SELECT 
    mv.marque,
    mv.modele,
    COUNT(r.id) AS nbre_reparation
FROM Modele_voiture mv
LEFT JOIN Reparation r ON mv.id = r.id_modele_voiture
GROUP BY mv.marque, mv.modele
ORDER BY mv.marque, mv.modele;