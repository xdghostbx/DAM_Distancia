(: 6- modelo de las impresoras tipo "laser":)
for $x in doc("impresoras.xml")/impresoras/impresora
where $x[@tipo = "láser"]
return data ($x/modelo)