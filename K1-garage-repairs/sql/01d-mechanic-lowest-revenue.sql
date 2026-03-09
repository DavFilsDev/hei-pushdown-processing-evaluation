-- Question d: Mechanic with lowest total repair cost
SELECT 
    m.nom AS mecanicien,
    COALESCE(SUM(r.cout), 0) AS cout_reparation_rapporte
FROM Mecanicien m
LEFT JOIN Reparation r ON m.id = r.id_mecanicien
GROUP BY m.id, m.nom
ORDER BY cout_reparation_rapporte ASC
LIMIT 1;