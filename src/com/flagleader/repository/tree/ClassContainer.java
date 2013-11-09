package com.flagleader.repository.tree;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.xml.TreeFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassContainer extends AbstractBOContainer
  implements IBusinessObjectContainer, IBusinessObject, IWhileObject
{
  public static final String NAME = "ClassContainer";
  public static final String DISPLAYNAME = getLocalString("ClassContainer.text");
  public static final String COMMONNAME = getLocalString("ClassContainer.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("ClassContainer", DISPLAYNAME, DISPLAYNAME);
  private int multiType = 0;
  private transient d updater = null;
  public static final int ONENULL = 0;
  public static final int ONEMUST = 1;
  public static final int MULTINULL = 2;
  public static final int MULTIMUST = 3;
  public int loadType = 1;
  public static final int LOADTEMP = 0;
  public static final int LOADCONTEXT = 1;
  private String nodeName = null;

  public ClassContainer()
  {
  }

  public ClassContainer(ClassContainer paramClassContainer)
  {
    super(paramClassContainer);
    this.multiType = paramClassContainer.multiType;
    this.nodeName = paramClassContainer.nodeName;
    this.loadType = paramClassContainer.loadType;
  }

  public ClassContainer(String paramString)
  {
    super(paramString);
  }

  public ClassContainer(BusinessObjectClass paramBusinessObjectClass)
  {
    super(paramBusinessObjectClass.getShortClassName().toLowerCase());
    addClassToken(paramBusinessObjectClass);
    paramBusinessObjectClass.fillAllMembers();
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitClassLibrary(this);
  }

  public boolean isSingleValue()
  {
    return (this.multiType == 1) || (this.multiType == 0);
  }

  public String getNodeName()
  {
    if (this.nodeName == null)
      return getDisplayName();
    return this.nodeName;
  }

  public void setNodeName(String paramString)
  {
    this.nodeName = paramString;
  }

  public void reload()
  {
    e();
  }

  private void e()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof BusinessObjectClass))
        continue;
      ((BusinessObjectClass)localObject).reload();
    }
  }

  public BusinessObjectClass getBusinessObjectClass()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof BusinessObjectClass))
        return (BusinessObjectClass)localObject;
    }
    return null;
  }

  public void addClassToken(BusinessObjectClass paramBusinessObjectClass)
  {
    addChildElement(paramBusinessObjectClass);
  }

  public void removeClassToken(BusinessObjectClass paramBusinessObjectClass)
  {
    removeChildElement(paramBusinessObjectClass);
  }

  public void removeChildElement(IElement paramIElement)
  {
    if (!a(paramIElement))
      return;
    super.removeChildElement(paramIElement);
  }

  public void addChildElement(IElement paramIElement)
  {
    if (!a(paramIElement))
      return;
    super.addChildElement(paramIElement);
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof BusinessObjectClass)) || ((paramIElement instanceof IFunctionObject));
  }

  public BusinessObjectClass getClassToken(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof BusinessObjectClass)) && (((BusinessObjectClass)localObject).getClassName().equals(paramString)))
        return (BusinessObjectClass)localObject;
    }
    return null;
  }

  public IElement deepClone()
  {
    return new ClassContainer(this);
  }

  public boolean isLocked()
  {
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return getParent().isLocked();
    return super.isLocked();
  }

  public String getName()
  {
    return "ClassContainer";
  }

  public int getMultiType()
  {
    return this.multiType;
  }

  public void setMultiType(int paramInt)
  {
    this.multiType = paramInt;
  }

  public void setVisible(boolean paramBoolean)
  {
  }

  public boolean canCreateEditen()
  {
    return false;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    return null;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return false;
  }

  public void sortBy(int paramInt, String paramString, boolean paramBoolean)
  {
  }

  public List getCanCreateSubFunction()
  {
    return getEnvionment().getClassMembers(this, true);
  }

  public boolean createSubFunction(List paramList)
  {
    for (int i = 0; (paramList != null) && (i < paramList.size()); i++)
    {
      ((IBusinessObject)paramList.get(i)).setVisible(true);
      addChildElement((IBusinessObject)paramList.get(i));
    }
    return (paramList != null) && (paramList.size() > 0);
  }

  public boolean isEditVisible()
  {
    return false;
  }

  public void changeValueType(String paramString)
  {
  }

  public List getAllParams()
  {
    return new ArrayList(0);
  }

  public IBusinessObjectContainer getContainer()
  {
    return this;
  }

  public g getJavaType()
  {
    return getTypeManager().a(getValueType());
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public String getUniqueName()
  {
    return getVarName();
  }

  public String getValueName()
  {
    return getVarName();
  }

  public String getValueType()
  {
    return "com.flagleader.xml.ClassValue";
  }

  public String getVarValue()
  {
    return getVarName();
  }

  public String getVarName()
  {
    return "class" + getParent().getElementPos(this);
  }

  public List getAllEditens()
  {
    return null;
  }

  public Iterator getEditens()
  {
    return d().iterator();
  }

  protected List d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IBusinessObjectEditen))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public TreeFunction getTreeFunction(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof TreeFunction)) && (((TreeFunction)localObject).getValueName().equals(paramString)))
        return (TreeFunction)localObject;
    }
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
    ArrayList localArrayList = new ArrayList(1);
    for (int i = 0; i < paramArrayOfString.length; i++)
      localArrayList.add(new MethodParam(paramArrayOfString[i], i));
    return localArrayList;
  }

  public void clearfunction()
  {
    for (int i = a().size() - 1; i >= 0; i--)
    {
      if (!(a().get(i) instanceof TreeFunction))
        continue;
      removeElement(i);
    }
  }

  public void resetFunction()
  {
    if (isSingleValue())
      clearfunction();
    else
      updateFunction();
  }

  public void updateFunction()
  {
    if (getTreeFunction("beforeFirst") == null)
    {
      addChildElement(new TreeFunction("beforeFirst", "void", "beforeFirst()", format("beforeFirst.sheet", new Object[] { getDisplayName() }), null, getLocalString("beforeFirst.sheetgroup")));
    }
    else
    {
      getTreeFunction("beforeFirst").setDisplayName(format("beforeFirst.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("beforeFirst").setGroupName(getLocalString("beforeFirst.sheetgroup"));
    }
    if (getTreeFunction("next") == null)
    {
      addChildElement(new TreeFunction("next", "boolean", "next()", format("next.sheet", new Object[] { getDisplayName() }), null, getLocalString("next.sheetgroup")));
    }
    else
    {
      getTreeFunction("next").setDisplayName(format("next.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("next").setGroupName(getLocalString("next.sheetgroup"));
    }
    if (getTreeFunction("getRows") == null)
    {
      addChildElement(new TreeFunction("getRows", "int", "getRows()", format("getRows.sheet", new Object[] { getDisplayName() }), null, getLocalString("getRows.sheetgroup")));
    }
    else
    {
      getTreeFunction("getRows").setDisplayName(format("getRows.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("getRows").setGroupName(getLocalString("getRows.sheetgroup"));
    }
    if (getTreeFunction("first") == null)
    {
      addChildElement(new TreeFunction("first", "boolean", "first()", format("first.sheet", new Object[] { getDisplayName() }), null, getLocalString("first.sheetgroup")));
    }
    else
    {
      getTreeFunction("first").setDisplayName(format("first.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("first").setGroupName(getLocalString("first.sheetgroup"));
    }
    if (getTreeFunction("afterLast") == null)
    {
      addChildElement(new TreeFunction("afterLast", "void", "afterLast()", format("afterLast.sheet", new Object[] { getDisplayName() }), null, getLocalString("afterLast.sheetgroup")));
    }
    else
    {
      getTreeFunction("afterLast").setDisplayName(format("afterLast.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("afterLast").setGroupName(getLocalString("afterLast.sheetgroup"));
    }
    if (getTreeFunction("previous") == null)
    {
      addChildElement(new TreeFunction("previous", "boolean", "previous()", format("previous.sheet", new Object[] { getDisplayName() }), null, getLocalString("previous.sheetgroup")));
    }
    else
    {
      getTreeFunction("previous").setDisplayName(format("previous.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("previous").setGroupName(getLocalString("previous.sheetgroup"));
    }
    if (getTreeFunction("last") == null)
    {
      addChildElement(new TreeFunction("last", "boolean", "last()", format("last.sheet", new Object[] { getDisplayName() }), null, getLocalString("last.sheetgroup")));
    }
    else
    {
      getTreeFunction("last").setDisplayName(format("last.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("last").setGroupName(getLocalString("last.sheetgroup"));
    }
    if (getTreeFunction("getCurrentRow") == null)
    {
      addChildElement(new TreeFunction("getCurrentRow", "int", "getCurrentRow()", format("getCurrentRow.sheet", new Object[] { getDisplayName() }), null, getLocalString("getCurrentRow.sheetgroup")));
    }
    else
    {
      getTreeFunction("getCurrentRow").setDisplayName(format("getCurrentRow.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("getCurrentRow").setGroupName(getLocalString("getCurrentRow.sheetgroup"));
    }
    if (getTreeFunction("gotoRow") == null)
    {
      addChildElement(new TreeFunction("gotoRow", "int", "gotoRow({arg1})", format("gotoRow.sheet", new Object[] { getDisplayName(), "{arg1}" }), a("int"), getLocalString("gotoRow.sheetgroup")));
    }
    else
    {
      getTreeFunction("gotoRow").setDisplayName(format("gotoRow.sheet", new Object[] { getDisplayName(), "{arg1}" }));
      getTreeFunction("gotoRow").setGroupName(getLocalString("gotoRow.sheetgroup"));
    }
    if (getTreeFunction("insert") == null)
    {
      addChildElement(new TreeFunction("insert", "void", "insert()", format("insert.sheet", new Object[] { getDisplayName() }), null, getLocalString("insert.sheetgroup")));
    }
    else
    {
      getTreeFunction("insert").setDisplayName(format("insert.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("insert").setGroupName(getLocalString("insert.sheetgroup"));
    }
    if (getTreeFunction("delete") == null)
    {
      addChildElement(new TreeFunction("delete", "void", "delete()", format("delete.sheet", new Object[] { getDisplayName() }), null, getLocalString("delete.sheetgroup")));
    }
    else
    {
      getTreeFunction("delete").setDisplayName(format("delete.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("delete").setGroupName(getLocalString("delete.sheetgroup"));
    }
    if (getTreeFunction("resetValues") == null)
    {
      addChildElement(new TreeFunction("resetValues", "void", "resetValues()", format("resetValues.sheet", new Object[] { getDisplayName() }), null, getLocalString("resetValues.sheetgroup")));
    }
    else
    {
      getTreeFunction("resetValues").setDisplayName(format("resetValues.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("resetValues").setGroupName(getLocalString("resetValues.sheetgroup"));
    }
  }

  public void setObjectEditor(d paramd)
  {
    this.updater = paramd;
  }

  public void updateEditor()
  {
    if (this.updater != null)
      this.updater.a();
  }

  public void update()
  {
    updateEditor();
  }

  public void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4)
  {
  }

  public boolean exitsFields(Object paramObject)
  {
    BusinessObjectClass localBusinessObjectClass = getBusinessObjectClass();
    Iterator localIterator = localBusinessObjectClass.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof BusinessObjectAttribute)) && (((BusinessObjectAttribute)localObject).getMemberName().equals(((BusinessObjectAttribute)paramObject).getMemberName())) && (((BusinessObjectAttribute)localObject).getDisplayName().equals(((BusinessObjectAttribute)paramObject).getDisplayName())))
        return true;
    }
    return false;
  }

  public Iterator getFieldIterator()
  {
    return getFields().iterator();
  }

  public List getFields()
  {
    ArrayList localArrayList = new ArrayList();
    BusinessObjectClass localBusinessObjectClass = getBusinessObjectClass();
    Iterator localIterator = localBusinessObjectClass.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof BusinessObjectAttribute))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public boolean mustWhile()
  {
    return false;
  }

  public int getLoadType()
  {
    return this.loadType;
  }

  public void setLoadType(int paramInt)
  {
    this.loadType = paramInt;
  }

  public boolean isLoadContext()
  {
    return this.loadType == 1;
  }

  public boolean isCreated()
  {
    return (this.multiType == 1) || (this.multiType == 3);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ClassContainer
 * JD-Core Version:    0.6.0
 */