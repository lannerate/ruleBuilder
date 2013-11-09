package com.flagleader.manager.c;

import com.flagleader.manager.r;
import com.flagleader.repository.tree.IPackageElement;

public abstract class e extends h
{
  public static String[] a = com.flagleader.manager.d.c.d("vmlviewtypes.PackageElementProperties");

  static
  {
    for (int i = 0; i < a.length; i++)
      a[i] = com.flagleader.manager.d.c.b(a[i] + ".PackageElementProperties");
  }

  public e(c paramc, IPackageElement paramIPackageElement, r paramr)
  {
    super(paramc, paramIPackageElement, paramr);
  }

  public IPackageElement c()
  {
    if ((d() != null) && ((d() instanceof IPackageElement)))
      return (IPackageElement)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.e
 * JD-Core Version:    0.6.0
 */