-- Question a: Number of parts sold by car brand
SELECT 
    mv.marque,
    COALESCE(SUM(v.quantite), 0) AS nbre_piece
FROM Modele_voiture mv
LEFT JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
LEFT JOIN Vente v ON pa.id = v.id_piece_auto
GROUP BY mv.marque
ORDER BY mv.marque;