package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.r;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.ITreeNode;

public class aL extends e
{
  public aL(com.flagleader.manager.c.c paramc, SoapService paramSoapService, r paramr)
  {
    super(paramc, paramSoapService, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.SoapServicePropertiesEditor"), new l(this));
    a(com.flagleader.manager.d.c.b("nodeName.SoapServicePropertiesEditor"), new aP(this));
    a(com.flagleader.manager.d.c.b("endpointURL.SoapServicePropertiesEditor"), new aO(this));
    a(com.flagleader.manager.d.c.b("resultType.SoapServicePropertiesEditor"), new aT(this));
    a(com.flagleader.manager.d.c.b("serviceNS.SoapServicePropertiesEditor"), new aU(this));
    a(com.flagleader.manager.d.c.b("serviceName.SoapServicePropertiesEditor"), new aV(this));
    a(com.flagleader.manager.d.c.b("operationName.SoapServicePropertiesEditor"), new aQ(this));
    a(com.flagleader.manager.d.c.b("portName.SoapServicePropertiesEditor"), new aS(this));
    a(com.flagleader.manager.d.c.b("actionUrl.SoapServicePropertiesEditor"), new aM(this));
    a(com.flagleader.manager.d.c.b("soapVersion.SoapServicePropertiesEditor"), new aW(this));
    a(com.flagleader.manager.d.c.b("paramNS.SoapServicePropertiesEditor"), new aR(this));
  }

  public SoapService f()
  {
    if ((d() != null) && ((d() instanceof SoapService)))
      return (SoapService)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aL
 * JD-Core Version:    0.6.0
 */