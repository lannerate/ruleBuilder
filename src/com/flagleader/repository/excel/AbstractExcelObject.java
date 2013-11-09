package com.flagleader.repository.excel;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.d;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.AbstractBOContainer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractExcelObject extends AbstractBOContainer
  implements IExcelObject
{
  private transient d updater = null;

  public AbstractExcelObject()
  {
  }

  public AbstractExcelObject(AbstractBOContainer paramAbstractBOContainer)
  {
    super(paramAbstractBOContainer);
  }

  public AbstractExcelObject(String paramString)
  {
    super(paramString);
  }

  public ExcelFunction getExcelFunction(String paramString)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof ExcelFunction)) && (((ExcelFunction)localList.get(i)).getValueName().equals(paramString)))
        return (ExcelFunction)localList.get(i);
    return null;
  }

  protected List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new MethodParam(paramString, 0));
    return localArrayList;
  }

  protected List a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
    for (int i = 0; i < paramArrayOfString.length; i++)
      localArrayList.add(new MethodParam(paramArrayOfString[i], i));
    return localArrayList;
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
      ((IBusinessObjectEditen)localList.get(i)).changeDisplayName(paramString1, paramString2);
    }
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public void changeValueType(String paramString)
  {
  }

  public boolean createSubFunction(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      ((IBusinessObject)paramList.get(i)).setVisible(true);
      addChildElement((IBusinessObject)paramList.get(i));
      setModified(true);
    }
    return true;
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
    if (getParent() != null)
      return getParent().getDisplayName();
    return getDisplayName();
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

  public IBusinessObjectContainer getContainer()
  {
    return this;
  }

  public boolean isEditVisible()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.AbstractExcelObject
 * JD-Core Version:    0.6.0
 */