package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;

class A
  implements ChildAcceptor
{
  A(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof SoapParameter)) && (((SoapParameter)paramObject).isEditVisible());
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof SoapService;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.A
 * JD-Core Version:    0.6.0
 */