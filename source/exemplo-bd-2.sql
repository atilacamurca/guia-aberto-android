SELECT d._id, d.nome, d.interface,
(
   SELECT SUM( CASE WHEN aux.deriva_de = d._id THEN 1 ELSE 0 END )
   FROM distros aux
) AS num_derivadas
FROM distros d
