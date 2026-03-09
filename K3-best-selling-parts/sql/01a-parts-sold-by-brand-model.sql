-- Question a: Total number of parts sold by brand and model
SELECT 
    mv.marque,
    mv.modele,
    COALESCE(SUM(v.quantite), 0) AS nbre_pieces_vendus
FROM Modele_voiture mv
LEFT JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
LEFT JOIN Vente v ON pa.id = v.id_piece_auto
GROUP BY mv.marque, mv.modele
ORDER BY mv.marque, mv.modele;