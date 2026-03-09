-- Question c: Total price of parts sold for KIA brand
SELECT 
    COALESCE(SUM(pa.prix * v.quantite), 0) AS prix_total_kia
FROM Modele_voiture mv
JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
JOIN Vente v ON pa.id = v.id_piece_auto
WHERE mv.marque = 'KIA';