package com.flagleader.repository.rlm.value;

import com.flagleader.repository.ElementList;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.b;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemberTreeToken extends MemberToken
  implements IStatementToken
{
  public MemberTreeToken(MemberTreeToken paramMemberTreeToken)
  {
    super(paramMemberTreeToken);
  }

  public MemberTreeToken()
  {
  }

  public MemberTreeToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new MemberTreeToken(this);
  }

  public com.flagleader.repository.l[] getLeftPopupMenus()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getEnvionment().getAcceptChildren(new l(this));
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
        a(localTreeValueNode.getAcceptElements(new m(this)));
        if ((this.b.size() == 0) && (!getJavaType().B()))
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
        localObject3 = new com.flagleader.repository.l(((ElementList)localObject2).getDisplayName(), new b(this, ((ElementList)localObject2).getElement()), ((ElementList)localObject2).getElement());
        ((ArrayList)localObject1).add(localObject3);
        a((com.flagleader.repository.l)localObject3, (ElementList)localObject2);
      }
      else
      {
        ((ArrayList)localObject1).add(new com.flagleader.repository.l(((IElement)localArrayList.get(i)).getDisplayName(), new b(this, (IElement)localArrayList.get(i)), (IElement)localArrayList.get(i)));
      }
    com.flagleader.repository.l[] arrayOfl = new com.flagleader.repository.l[((ArrayList)localObject1).size()];
    for (i = 0; i < ((ArrayList)localObject1).size(); i++)
      arrayOfl[i] = ((com.flagleader.repository.l)((ArrayList)localObject1).get(i));
    return (com.flagleader.repository.l)(com.flagleader.repository.l)(com.flagleader.repository.l)arrayOfl;
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
    return getEnvionment().getAcceptElements(new n(this));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if (((paramObject instanceof IBusinessObject)) && (((IBusinessObject)paramObject).isEditVisible()))
    {
      IBusinessObject localIBusinessObject = (IBusinessObject)paramObject;
      if ((localIBusinessObject instanceof IVariableObject))
      {
        if ((str == null) || (str.length() == 0) || (localIBusinessObject.getJavaType().c(str)))
          return true;
      }
      else if ((localIBusinessObject instanceof IFunctionObject))
      {
        if (((str != null) && (str.length() != 0)) || ((!localIBusinessObject.getJavaType().l()) || (localIBusinessObject.getJavaType().c(str))))
          return true;
      }
      else if (((localIBusinessObject instanceof TreeValueNode)) && (str != null) && (str.length() > 0) && (!localIBusinessObject.getJavaType().l()) && (localIBusinessObject.getJavaType().c(str)))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "MemberTreeToken";
  }

  protected String i()
  {
    return getLocalString("selectTreeMember.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.MemberTreeToken
 * JD-Core Version:    0.6.0
 */