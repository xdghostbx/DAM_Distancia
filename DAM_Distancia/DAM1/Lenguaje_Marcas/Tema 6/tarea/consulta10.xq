(: 10- Modelo de las impresoras en red:)
for $x in doc("impresoras.xml")/impresoras/impresora
where ($x/enred)
return <impresora>
      <modelo>
          {$x/modelo/text()}
      </modelo>
  </impresora>


  (: Modelo de las impresoras en red :)
for $x in doc("impresoras.xml")/impresoras/impresora
where$x/enred
return $x/modelo