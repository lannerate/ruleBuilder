package com.flagleader.repository.db;

import com.flagleader.repository.d;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.tree.AbstractBOContainer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBOAndContainer extends AbstractBOContainer
  implements IBusinessObjectEditen
{
  private transient d updater = null;

  public AbstractBOAndContainer()
  {
  }

  public AbstractBOAndContainer(AbstractBOContainer paramAbstractBOContainer)
  {
    super(paramAbstractBOContainer);
  }

  public AbstractBOAndContainer(String paramString)
  {
    super(paramString);
  }

  public List getAllParams()
  {
    return new ArrayList(0);
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public String getUniqueName()
  {
    return getVarValue();
  }

  public void setVisible(boolean paramBoolean)
  {
  }

  public boolean canCreateSubFunction()
  {
    return true;
  }

  public void changeDisplayName(String paramString1, String paramString2)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IBusinessObjectEditen))
        continue;
      ((IBusinessObjectEditen)localList.get(i)).setDisplayName(StringUtil.replace(paramString1, paramString2, ((IBusinessObjectEditen)localList.get(i)).getDisplayName()));
      ((IBusinessObjectEditen)localList.get(i)).changeDisplayName(paramString1, ((IBusinessObjectEditen)localList.get(i)).getDisplayName());
    }
    setDisplayName(paramString2);
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public void changeValueType(String paramString)
  {
  }

  public boolean createSubFunction(List paramList)
  {
    int i = 0;
    for (int j = 0; j < paramList.size(); j++)
    {
      ((IBusinessObject)paramList.get(j)).setVisible(true);
      addChildElement((IBusinessObject)paramList.get(j));
      i = 1;
    }
    setModified(true);
    return i;
  }

  public List getAllSubEditens()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    if (hasSubEditen())
    {
      Iterator localIterator = getSubEditens();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof IBusinessObjectEditen))
          continue;
        localArrayList.add(localObject);
        localArrayList.addAll(((IBusinessObjectEditen)localObject).getAllSubEditens());
      }
    }
    return localArrayList;
  }

  public List getCanCreateSubFunction()
  {
    return getEnvionment().getClassMembers(this, true);
  }

  public g getJavaType()
  {
    return getTypeManager().a(getValueType());
  }

  public String getShowGroupName()
  {
    return "";
  }

  public String getStringPos(int paramInt)
  {
    if (paramInt == 0)
      return getValueName();
    if (paramInt == 1)
      return getValueType();
    if (paramInt == 2)
      return getDisplayName();
    if (paramInt == 3)
      return getVarValue();
    if (paramInt == 4)
      return getShowGroupName();
    return getDisplayName();
  }

  public Iterator getSubEditens()
  {
    return getChildrenIterator();
  }

  public boolean hasSubEditen()
  {
    return getSubEditens().hasNext();
  }

  public void updateEditor()
  {
    if (this.updater != null)
      this.updater.a();
  }

  public void setObjectEditor(d paramd)
  {
    this.updater = paramd;
  }

  public void dispose()
  {
    d();
    super.dispose();
  }

  protected void d()
  {
    this.updater = null;
  }

  public boolean isGroupEditable()
  {
    return false;
  }

  public boolean isTypeEditable()
  {
    return false;
  }

  public boolean isValueEditable()
  {
    return false;
  }

  public void setShowGroupName(String paramString)
  {
  }

  public void setValueName(String paramString)
  {
  }

  public void update()
  {
    updateEditor();
  }

  public String getInitName()
  {
    if (getMainPackage() != null)
      return getMainPackage().getExeRulePackageName() + getMainPackage().getVersion() + getVarValue();
    return getUuid();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.AbstractBOAndContainer
 * JD-Core Version:    0.6.0
 */