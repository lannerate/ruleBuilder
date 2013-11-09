package com.flagleader.repository.rlm.action;

import com.flagleader.repository.ElementList;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.l;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.b;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.xml.XmlFunction;
import com.flagleader.repository.xml.XmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlFunctionToken extends MemberToken
  implements IStatementToken
{
  public XmlFunctionToken(XmlFunctionToken paramXmlFunctionToken)
  {
    super(paramXmlFunctionToken);
  }

  public XmlFunctionToken()
  {
  }

  public XmlFunctionToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new XmlFunctionToken(this);
  }

  public l[] getLeftPopupMenus()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getEnvionment().getAcceptChildren(new T(this));
    while (localIterator.hasNext())
    {
      localObject = (XmlNode)localIterator.next();
      ElementList localElementList1 = new ElementList((IElement)localObject);
      localArrayList.add(localElementList1);
      a(((XmlNode)localObject).getAcceptElements(new U(this)));
      if (this.b.size() == 0)
        localArrayList.remove(localElementList1);
      else
        for (int j = 0; j < this.b.size(); j++)
        {
          if (!(this.b.get(j) instanceof IElement))
            continue;
          localElementList1.add((IElement)this.b.get(j));
        }
    }
    Object localObject = new ArrayList(localArrayList.size());
    for (int i = 0; i < localArrayList.size(); i++)
      if ((localArrayList.get(i) instanceof ElementList))
      {
        ElementList localElementList2 = (ElementList)localArrayList.get(i);
        if (localElementList2.size() <= 0)
          continue;
        l locall = new l(localElementList2.getDisplayName(), new b(this, localElementList2.getElement()), localElementList2.getElement());
        ((ArrayList)localObject).add(locall);
        a(locall, localElementList2);
      }
      else
      {
        ((ArrayList)localObject).add(new l(((IElement)localArrayList.get(i)).getDisplayName(), new b(this, (IElement)localArrayList.get(i)), (IElement)localArrayList.get(i)));
      }
    l[] arrayOfl = new l[((ArrayList)localObject).size()];
    for (i = 0; i < ((ArrayList)localObject).size(); i++)
      arrayOfl[i] = ((l)((ArrayList)localObject).get(i));
    return (l)arrayOfl;
  }

  protected ElementList a(IBusinessObjectContainer paramIBusinessObjectContainer)
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      if (((this.b.get(j) instanceof ElementList)) && (((ElementList)this.b.get(j)).getElement().equals(paramIBusinessObjectContainer)))
        return (ElementList)this.b.get(j);
    ElementList localElementList = new ElementList(paramIBusinessObjectContainer);
    this.b.add(localElementList);
    return localElementList;
  }

  protected Iterator e()
  {
    return getEnvionment().getAcceptElements(new V(this));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if (((localIBusinessObjectEditen instanceof XmlFunction)) || ((localIBusinessObjectEditen instanceof ISubFunction)))
      {
        if ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(str)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof XmlNode)) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(str))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "XmlFunctionToken";
  }

  protected String i()
  {
    return getLocalString("selectXmlFunction.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.XmlFunctionToken
 * JD-Core Version:    0.6.0
 */