package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.e.m;
import java.util.HashMap;
import java.util.Map;

public class RuleMirror extends AbstractRuleTree
  implements IRuleTree, am
{
  public static final String NAME = "RuleMirror";
  public static final String DISPLAYNAME = getLocalString("RuleMirror.text");
  public static final String COMMNAME = getLocalString("RuleMirror.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("RuleMirror", DISPLAYNAME, DISPLAYNAME);
  private String elementUuid = "";

  public RuleMirror(RuleMirror paramRuleMirror)
  {
    super(paramRuleMirror);
    this.elementUuid = paramRuleMirror.elementUuid;
  }

  public RuleMirror()
  {
  }

  public RuleMirror(String paramString1, String paramString2)
  {
    super(paramString1);
    this.elementUuid = paramString2;
  }

  public String getName()
  {
    return "RuleMirror";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRuleMirror(this);
  }

  public void setMemberElement(IElement paramIElement)
  {
    if (paramIElement == null)
      return;
    this.elementUuid = paramIElement.getUuid();
    setDisplayName(paramIElement.getDisplayName());
  }

  public boolean isEmpty()
  {
    IElement localIElement = getMemberElement();
    return (localIElement == null) || (!(localIElement instanceof am)) || (((am)localIElement).isEmpty());
  }

  public IElement getMemberElement()
  {
    IElement localIElement = null;
    if ((getElementUuid().length() > 0) || (getDisplayName().length() > 0))
      localIElement = h();
    if (localIElement != null)
    {
      setElementUuid(localIElement.getUuid());
      setDisplayName(localIElement.getDisplayName());
    }
    return localIElement;
  }

  protected IElement h()
  {
    IElement localIElement = null;
    if (getEnvionment() != null)
      localIElement = getEnvionment().getRuleObject(getElementUuid(), getDisplayName());
    return localIElement;
  }

  public String getDisplayName()
  {
    return super.getDisplayName();
  }

  public IElement deepClone()
  {
    return new RuleMirror(this);
  }

  public String getElementUuid()
  {
    return this.elementUuid;
  }

  public void setElementUuid(String paramString)
  {
    this.elementUuid = paramString;
  }

  public int getPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)) && (getParent().getElementPos(this) >= 0))
      return getParent().getElementPos(this);
    return 0;
  }

  public int getMaxPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)))
      return ((IRuleSet)getParent()).getRuleAndSetCount();
    return 0;
  }

  public void setPos(int paramInt)
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)))
    {
      if (paramInt < 0)
        return;
      int i = getParent().getElementPos(this);
      if (i == paramInt)
        return;
      getParent().removeChildElement(this);
      getParent().addChildElement(this, paramInt);
    }
  }

  public int getMinPos()
  {
    return 0;
  }

  public Map getRelateObjectMap(Map paramMap)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    IElement localIElement = h();
    if ((localIElement != null) && ((localIElement instanceof am)))
      ((am)localIElement).getRelateObjectMap(paramMap);
    return paramMap;
  }

  public Map getAssignObjectMap(Map paramMap, boolean paramBoolean)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    IElement localIElement = h();
    if ((localIElement != null) && ((localIElement instanceof am)))
      ((am)localIElement).getAssignObjectMap(paramMap, paramBoolean);
    return paramMap;
  }

  protected String d()
  {
    return new m().b(this);
  }

  public int getRuleTableCount()
  {
    return 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleMirror
 * JD-Core Version:    0.6.0
 */