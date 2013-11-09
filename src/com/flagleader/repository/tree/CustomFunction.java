package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.util.Iterator;

public class CustomFunction extends AbstractBOContainer
{
  public static final String NAME = "CustomFunction";
  public static final String DISPLAYNAME = getLocalString("CustomFunction.text");
  public static final NodeInfo nodeInfo = new NodeInfo("CustomFunction", DISPLAYNAME, DISPLAYNAME);

  public CustomFunction(CustomFunction paramCustomFunction)
  {
    super(paramCustomFunction);
  }

  public CustomFunction()
  {
  }

  public CustomFunction(String paramString)
  {
    super(paramString);
    addChildElement(new FunctionMember());
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitCustomFunction(this);
  }

  public IElement deepClone()
  {
    return new CustomFunction(this);
  }

  protected boolean a(IElement paramIElement)
  {
    return (paramIElement instanceof FunctionMember);
  }

  public String getName()
  {
    return "CustomFunction";
  }

  public int getFunctionNum()
  {
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      ((Envionment)getParent()).getFunctionNum();
    return 0;
  }

  public FunctionMember getFunctionMember()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof FunctionMember))
        return (FunctionMember)localObject;
    }
    return null;
  }

  public boolean isLocked()
  {
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return getParent().isLocked();
    return super.isLocked();
  }

  public void setModified(boolean paramBoolean)
  {
    super.setModified(paramBoolean);
    if ((paramBoolean) && (getEnvionment() != null))
      getEnvionment().setModified(true);
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    return null;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.CustomFunction
 * JD-Core Version:    0.6.0
 */