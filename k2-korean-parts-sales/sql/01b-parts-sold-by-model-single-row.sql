-- Question b: Number of parts sold by model (single row result)
SELECT 
    COALESCE(SUM(CASE WHEN mv.modele = 'GETZ' THEN v.quantite ELSE 0 END), 0) AS nbre_piece_getz,
    COALESCE(SUM(CASE WHEN mv.modele = 'PRIDE' THEN v.quantite ELSE 0 END), 0) AS nbre_piece_pride,
    COALESCE(SUM(CASE WHEN mv.modele = 'LACETTI' THEN v.quantite ELSE 0 END), 0) AS nbre_piece_lacetti
FROM Modele_voiture mv
LEFT JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
LEFT JOIN Vente v ON pa.id = v.id_piece_auto;