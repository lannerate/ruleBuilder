package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.XmlNode;

public class bj extends e
{
  public static String[] e = com.flagleader.manager.d.c.d("multitypes.XmlNodePropertiesEditor");
  public static String[] f;

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".XmlNodePropertiesEditor");
    f = com.flagleader.manager.d.c.d("froms.XmlNodePropertiesEditor");
    for (i = 0; i < f.length; i++)
      f[i] = com.flagleader.manager.d.c.b(f[i] + ".XmlNodePropertiesEditor");
  }

  public bj(com.flagleader.manager.c.c paramc, XmlNode paramXmlNode, r paramr)
  {
    super(paramc, paramXmlNode, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.XmlNodePropertiesEditor"), new l(this));
    a(com.flagleader.manager.d.c.b("nodeName.XmlNodePropertiesEditor"), new bn(this));
    if (f().isRootElement())
    {
      a(com.flagleader.manager.d.c.b("encode.XmlNodePropertiesEditor"), new bk(this));
      a(com.flagleader.manager.d.c.b("resource.XmlNodePropertiesEditor"), new bo(this));
      a(com.flagleader.manager.d.c.b("loadtype.XmlNodePropertiesEditor"), new bl(this));
    }
    else
    {
      a(com.flagleader.manager.d.c.b("multitype.XmlNodePropertiesEditor"), new bm(this));
    }
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }

  public XmlNode f()
  {
    if ((d() != null) && ((d() instanceof XmlNode)))
      return (XmlNode)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.bj
 * JD-Core Version:    0.6.0
 */