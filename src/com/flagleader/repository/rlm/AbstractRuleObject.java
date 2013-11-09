package com.flagleader.repository.rlm;

import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementEditor;
import com.flagleader.repository.lang.a;
import com.flagleader.repository.rlm.editen.IEditen;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractRuleObject extends AbstractElement
  implements IEditen
{
  public static final String DISPOSEEVENT = "&remove";
  private transient IElementEditor editor = null;
  protected String e = "";
  protected long f = 0L;
  protected String g = "";
  protected long h = 0L;

  public AbstractRuleObject()
  {
  }

  public AbstractRuleObject(AbstractRuleObject paramAbstractRuleObject)
  {
    super(paramAbstractRuleObject);
  }

  public IRuleContainer getRoot()
  {
    for (IElement localIElement = getParent(); (localIElement != null) && (!(localIElement instanceof IRuleContainer)); localIElement = localIElement.getParent());
    return (IRuleContainer)localIElement;
  }

  public String getNote()
  {
    return getLocalString(getName() + ".note", "");
  }

  public String toString()
  {
    return getDisplayName();
  }

  protected void g()
  {
    if (getRoot() != null)
    {
      getRoot().setModified(true);
      getRoot().takeSnapshot();
    }
  }

  protected void h()
  {
    if (getRoot() != null)
      getRoot().initUndoable();
  }

  public void dispose()
  {
    setElementEditor(null);
    super.dispose();
  }

  public Envionment getEnvionment()
  {
    IRuleContainer localIRuleContainer = getRoot();
    if ((localIRuleContainer != null) && (localIRuleContainer.getRuleTree() != null))
      return localIRuleContainer.getRuleTree().getEnvionment();
    if ((getParent() instanceof IRuleTree))
      return ((IRuleTree)getParent()).getEnvionment();
    return null;
  }

  public boolean isIgniorString()
  {
    if (getRoot().getRuleTree().getMainPackage() != null)
      return getRoot().getRuleTree().getMainPackage().isIgniorString();
    return false;
  }

  public int getDatenulltype()
  {
    if (getRoot().getRuleTree().getMainPackage() != null)
      return getRoot().getRuleTree().getMainPackage().getDatenulltype();
    return 0;
  }

  public ILineEditen getParentLine()
  {
    if ((this instanceof ILineEditen))
      return (ILineEditen)this;
    for (IElement localIElement = getParent(); (localIElement != null) && (!(localIElement instanceof ILineEditen)); localIElement = localIElement.getParent());
    if ((localIElement != null) && ((localIElement instanceof ILineEditen)))
      return (ILineEditen)localIElement;
    return null;
  }

  public void update()
  {
    if ((getParentLine() != null) && (!(this instanceof ILineEditen)))
      getParentLine().update();
    else if (this.editor != null)
      this.editor.update();
  }

  public IMultiLineEditen getContainer()
  {
    if ((this instanceof IMultiLineEditen))
      return (IMultiLineEditen)this;
    for (Object localObject = this; (((IElement)localObject).getParent() != null) && (!(((IElement)localObject).getParent() instanceof IMultiLineEditen)); localObject = ((IElement)localObject).getParent());
    if ((((IElement)localObject).getParent() != null) && ((((IElement)localObject).getParent() instanceof IMultiLineEditen)))
      return (IMultiLineEditen)((IElement)localObject).getParent();
    return (IMultiLineEditen)null;
  }

  public void setElementEditor(IElementEditor paramIElementEditor)
  {
    this.editor = paramIElementEditor;
  }

  public IElementEditor getElementEditor()
  {
    return this.editor;
  }

  public void findRelateObject(Map paramMap)
  {
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof IRuleObject))
        continue;
      ((IRuleObject)a().get(i)).findRelateObject(paramMap);
    }
  }

  public void findAssignObject(Map paramMap, boolean paramBoolean)
  {
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof IRuleObject))
        continue;
      ((IRuleObject)a().get(i)).findAssignObject(paramMap, paramBoolean);
    }
  }

  public List getAssignVarNames()
  {
    HashMap localHashMap = new HashMap();
    findAssignObject(localHashMap, false);
    ArrayList localArrayList = new ArrayList(localHashMap.size());
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
      localArrayList.add(localIterator.next());
    localHashMap.clear();
    return localArrayList;
  }

  public boolean isChanged()
  {
    IRuleContainer localIRuleContainer = getRoot();
    return (localIRuleContainer != null) && (localIRuleContainer.isChangeLine(toString()));
  }

  public String getText()
  {
    if ((getRoot() != null) && (this.f == getRoot().getRuleTree().getReloadTime()))
      return this.e;
    this.e = new com.flagleader.repository.e.m().b(this);
    if (getRoot() != null)
      this.f = getRoot().getRuleTree().getReloadTime();
    return this.e;
  }

  public String getJavaCode()
  {
    if (this.h == getRoot().getRuleTree().getReloadTime())
      return this.g;
    this.g = com.flagleader.repository.m.a().f().a().a(this);
    this.h = getRoot().getRuleTree().getReloadTime();
    return this.g;
  }

  public boolean canGetJavaCode()
  {
    Iterator localIterator = getAcceptChildren(new c(this));
    return !localIterator.hasNext();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.AbstractRuleObject
 * JD-Core Version:    0.6.0
 */