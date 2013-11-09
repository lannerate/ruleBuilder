package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.tree.ITreeNode;

public class ar extends e
{
  public static String[] e = com.flagleader.manager.d.c.d("implementTypes.SheetMapProperties");

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".SheetMapProperties");
  }

  public ar(com.flagleader.manager.c.c paramc, SheetMap paramSheetMap, r paramr)
  {
    super(paramc, paramSheetMap, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.SheetTableDialog"), new l(this));
    a(com.flagleader.manager.d.c.b("varName.SheetTableDialog"), new av(this));
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
    a(com.flagleader.manager.d.c.b("fromresource.SheetTableDialog"), new as(this));
    a(com.flagleader.manager.d.c.b("implementType.SheetMapProperties"), new au(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
    a(com.flagleader.manager.d.c.b("outtype.ValueLibraryEditor"), new at(this));
  }

  public SheetMap f()
  {
    if ((d() != null) && ((d() instanceof SheetMap)))
      return (SheetMap)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.ar
 * JD-Core Version:    0.6.0
 */