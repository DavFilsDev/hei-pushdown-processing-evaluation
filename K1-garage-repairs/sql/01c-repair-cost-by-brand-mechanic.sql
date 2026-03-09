-- Question c: Repair cost by brand and mechanic name
SELECT 
    mv.marque,
    m.nom AS nom_mecanicien,
    COALESCE(SUM(r.cout), 0) AS cout_reparation
FROM Modele_voiture mv
CROSS JOIN Mecanicien m
LEFT JOIN Reparation r ON m.id = r.id_mecanicien AND mv.id = r.id_modele_voiture
GROUP BY mv.marque, m.nom, m.id
ORDER BY mv.marque, m.nom;