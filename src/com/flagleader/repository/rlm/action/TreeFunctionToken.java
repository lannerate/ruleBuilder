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
import com.flagleader.repository.xml.TreeFunction;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeFunctionToken extends MemberToken
  implements IStatementToken
{
  public TreeFunctionToken(TreeFunctionToken paramTreeFunctionToken)
  {
    super(paramTreeFunctionToken);
  }

  public TreeFunctionToken()
  {
  }

  public TreeFunctionToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new TreeFunctionToken(this);
  }

  public l[] getLeftPopupMenus()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getEnvionment().getAcceptChildren(new Q(this));
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject1 = (TreeValueNode)localIterator.next();
      ElementList localElementList1 = new ElementList((IElement)localObject1);
      localArrayList.add(localElementList1);
      this.b = null;
      localObject2 = ((TreeValueNode)localObject1).getFieldIterator();
      while (((Iterator)localObject2).hasNext())
        localElementList1.add((IElement)((Iterator)localObject2).next());
      localObject3 = ((TreeValueNode)localObject1).getNodesIterator();
      while (((Iterator)localObject3).hasNext())
      {
        TreeValueNode localTreeValueNode = (TreeValueNode)((Iterator)localObject3).next();
        ElementList localElementList2 = new ElementList(localTreeValueNode);
        localElementList1.add(localElementList2);
        a(localTreeValueNode.getAcceptElements(new R(this)));
        if (this.b.size() == 0)
          localElementList1.remove(localElementList2);
        else
          for (int j = 0; j < this.b.size(); j++)
          {
            if (!(this.b.get(j) instanceof IElement))
              continue;
            localElementList2.add((IElement)this.b.get(j));
          }
      }
    }
    Object localObject1 = new ArrayList(localArrayList.size());
    for (int i = 0; i < localArrayList.size(); i++)
      if ((localArrayList.get(i) instanceof ElementList))
      {
        localObject2 = (ElementList)localArrayList.get(i);
        if (((ElementList)localObject2).size() <= 0)
          continue;
        localObject3 = new l(((ElementList)localObject2).getDisplayName(), new b(this, ((ElementList)localObject2).getElement()), ((ElementList)localObject2).getElement());
        ((ArrayList)localObject1).add(localObject3);
        a((l)localObject3, (ElementList)localObject2);
      }
      else
      {
        ((ArrayList)localObject1).add(new l(((IElement)localArrayList.get(i)).getDisplayName(), new b(this, (IElement)localArrayList.get(i)), (IElement)localArrayList.get(i)));
      }
    l[] arrayOfl = new l[((ArrayList)localObject1).size()];
    for (i = 0; i < ((ArrayList)localObject1).size(); i++)
      arrayOfl[i] = ((l)((ArrayList)localObject1).get(i));
    return (l)(l)(l)arrayOfl;
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
    return getEnvionment().getAcceptElements(new S(this));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((((localIBusinessObjectEditen instanceof TreeFunction)) || ((localIBusinessObjectEditen instanceof ISubFunction))) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(str))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "TreeFunctionToken";
  }

  protected String i()
  {
    return getLocalString("selectTreeFunction.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.TreeFunctionToken
 * JD-Core Version:    0.6.0
 */