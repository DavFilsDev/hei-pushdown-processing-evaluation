-- Question c: Percentage of sales by brand before January 1st, 2026
SELECT 
    mv.marque,
    ROUND(100.0 * SUM(v.quantite) / total.total_quantite, 2) AS pourcentage
FROM Modele_voiture mv
JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
JOIN Vente v ON pa.id = v.id_piece_auto
CROSS JOIN (
    SELECT SUM(quantite) AS total_quantite
    FROM Vente
    WHERE date < '2026-01-01'
) total
WHERE v.date < '2026-01-01'
GROUP BY mv.marque, total.total_quantite;