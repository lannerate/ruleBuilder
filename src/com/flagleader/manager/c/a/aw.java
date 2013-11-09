package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.ITreeNode;

public class aw extends e
{
  public static String[] e = com.flagleader.manager.d.c.d("nulldefaulttypes.SheetTableDialog");
  public static String[] f;
  public static String[] g;

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".SheetTableDialog");
    f = com.flagleader.manager.d.c.d("sharetypes.SheetTableDialog");
    for (i = 0; i < f.length; i++)
      f[i] = com.flagleader.manager.d.c.b(f[i] + ".SheetTableDialog");
    g = new String[4];
    g[0] = com.flagleader.manager.d.c.b("none.ValueLibraryEditor");
    g[1] = com.flagleader.manager.d.c.b("in.ValueLibraryEditor");
    g[2] = com.flagleader.manager.d.c.b("out.ValueLibraryEditor");
    g[3] = com.flagleader.manager.d.c.b("inout.ValueLibraryEditor");
  }

  public aw(com.flagleader.manager.c.c paramc, SheetTable paramSheetTable, r paramr)
  {
    super(paramc, paramSheetTable, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.SheetTableDialog"), new l(this));
    a(com.flagleader.manager.d.c.b("varName.SheetTableDialog"), new aK(this));
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
    if (f().isDBSheet())
      a(com.flagleader.manager.d.c.b("sqlStr.SheetTableDialog"), new aE(this));
    a(com.flagleader.manager.d.c.b("savevalue.SheetTableDialog"), new aC(this));
    a(com.flagleader.manager.d.c.b("linklist.SheetTableDialog"), new aA(this));
    a(com.flagleader.manager.d.c.b("fromresource.SheetTableDialog"), new ay(this));
    if (f().isFromResource())
    {
      a(com.flagleader.manager.d.c.b("excel.SheetTableDialog"), new aI(this));
      a(com.flagleader.manager.d.c.b("updateinternal.SheetTableDialog"), new aJ(this));
    }
    else if (f().getDBModel() != null)
    {
      a(com.flagleader.manager.d.c.b("fromdb.SheetTableDialog"), new ax(this));
      if (f().isFromDB())
      {
        a(com.flagleader.manager.d.c.b("sqlscript.SheetTableDialog"), new aG(this));
        a(com.flagleader.manager.d.c.b("updateinternal.SheetTableDialog"), new aJ(this));
      }
    }
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
    a(com.flagleader.manager.d.c.b("nulldefault.SheetTableDialog"), new aB(this));
    a(com.flagleader.manager.d.c.b("sharetype.SheetTableDialog"), new aD(this));
    a(com.flagleader.manager.d.c.b("outtype.ValueLibraryEditor"), new az(this));
  }

  public SheetTable f()
  {
    if ((d() != null) && ((d() instanceof SheetTable)))
      return (SheetTable)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aw
 * JD-Core Version:    0.6.0
 */