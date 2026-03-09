-- Question b: Total number of parts sold by brand (single row)
SELECT 
    COALESCE(SUM(CASE WHEN mv.marque = 'KIA' THEN v.quantite ELSE 0 END), 0) AS nbre_piece_kia,
    COALESCE(SUM(CASE WHEN mv.marque = 'DAEWOO' THEN v.quantite ELSE 0 END), 0) AS nbre_piece_daewoo
FROM Modele_voiture mv
LEFT JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
LEFT JOIN Vente v ON pa.id = v.id_piece_auto;