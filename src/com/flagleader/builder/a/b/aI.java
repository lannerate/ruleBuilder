package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.soap.ISoap;
import java.util.HashMap;
import java.util.List;

public class aI extends Thread
{
  ISoap a;
  private boolean c = false;

  public aI(aB paramaB)
  {
  }

  public void run()
  {
    try
    {
      this.c = false;
      this.a = this.b.e().getSoapInstance();
      List localList = this.b.e().getAllAttributes();
      for (int i = 0; i < localList.size(); i++)
      {
        SoapParameter localSoapParameter = (SoapParameter)localList.get(i);
        if ((localSoapParameter.getRetType() == 2) || (aB.b(this.b).get(localSoapParameter.getValueName()) == null))
          continue;
        this.a.setObject(localSoapParameter.getValueName(), this.b.e().getEnvionment().getTypeManager().a(localSoapParameter.getValueType()).f(aB.a(this.b, localSoapParameter.getValueName()).toString()));
      }
      this.a.invoke();
    }
    catch (Throwable localThrowable)
    {
      aB.c(this.b).getUserLogger().b(localThrowable.getMessage(), localThrowable);
    }
    finally
    {
      this.c = true;
    }
    super.run();
  }

  public ISoap a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aI
 * JD-Core Version:    0.6.0
 */