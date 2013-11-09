package org.agilemore.agilegrid.samples;

import java.util.HashMap;
import java.util.Map;
import org.agilemore.agilegrid.aa;

public class u extends aa
{
  private Map a = new HashMap();

  public u()
  {
    i locali = null;
    this.a.put(new o(0, 0), "001");
    this.a.put(new o(0, 1), "Tom");
    this.a.put(new o(0, 2), "13653477685");
    this.a.put(new o(0, 3), "123456");
    this.a.put(new o(0, 4), "tom@agilemore.com");
    locali = new i();
    locali.a(new j("IBM", "A great corporation.", Boolean.TRUE.booleanValue()));
    locali.a(new j("Samsung", "...", Boolean.FALSE.booleanValue()));
    locali.a(new j("Dell", "...", Boolean.FALSE.booleanValue()));
    this.a.put(new o(0, 5), locali);
    this.a.put(new o(1, 0), "002");
    this.a.put(new o(1, 1), "Jerry");
    this.a.put(new o(1, 2), "15948399584");
    this.a.put(new o(1, 3), "1533682");
    this.a.put(new o(1, 4), "jerry@agilemore.com");
    locali = new i();
    locali.a(new j("IBM", "A great corporation.", Boolean.TRUE.booleanValue()));
    locali.a(new j("Samsung", "...", Boolean.TRUE.booleanValue()));
    locali.a(new j("Dell", "...", Boolean.FALSE.booleanValue()));
    this.a.put(new o(1, 5), locali);
    this.a.put(new o(2, 0), "003");
    this.a.put(new o(2, 1), "Michael");
    this.a.put(new o(2, 2), "13458677463");
    this.a.put(new o(2, 3), "1236805");
    this.a.put(new o(2, 4), "michael@agilemore.com");
    locali = new i();
    locali.a(new j("IBM", "A great corporation.", Boolean.TRUE.booleanValue()));
    locali.a(new j("Samsung", "...", Boolean.TRUE.booleanValue()));
    locali.a(new j("Dell", "...", Boolean.TRUE.booleanValue()));
    this.a.put(new o(2, 5), locali);
  }

  public Object a(int paramInt1, int paramInt2)
  {
    o localo = new o(paramInt1, paramInt2);
    Object localObject = this.a.get(localo);
    return localObject != null ? localObject : "";
  }

  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    o localo = new o(paramInt1, paramInt2);
    this.a.put(localo, paramObject);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.u
 * JD-Core Version:    0.6.0
 */