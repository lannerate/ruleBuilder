package com.flagleader.repository.rom;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public abstract class AbstractBOEditen extends AbstractBusinessObject
  implements IBusinessObjectEditen
{
  public String groupName = "p";

  public AbstractBOEditen(AbstractBOEditen paramAbstractBOEditen)
  {
    super(paramAbstractBOEditen);
    this.groupName = paramAbstractBOEditen.groupName;
  }

  public AbstractBOEditen()
  {
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

  public Iterator getSubEditens()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IBusinessObjectEditen))
        continue;
      localArrayList.add(localList.get(i));
    }
    return localArrayList.iterator();
  }

  public boolean hasSubEditen()
  {
    return getSubEditens().hasNext();
  }

  public boolean isTypeEditable()
  {
    return false;
  }

  public boolean isValueEditable()
  {
    return false;
  }

  public boolean canDelete()
  {
    return true;
  }

  public boolean canCreateSubFunction()
  {
    g localg = getJavaType();
    return (localg.n()) || (localg.t()) || (localg.p());
  }

  public boolean createSubFunction(List paramList)
  {
    if (paramList.size() > 0)
    {
      for (int i = 0; i < paramList.size(); i++)
      {
        ((IBusinessObject)paramList.get(i)).setVisible(true);
        addChildElement((IBusinessObject)paramList.get(i));
      }
      getContainer().setModified(true);
      update();
      return true;
    }
    return false;
  }

  public List getCanCreateSubFunction()
  {
    if (getJavaType().n())
      return e();
    if (getJavaType().t())
      return f();
    if (getJavaType().p())
      return d();
    return new ArrayList(0);
  }

  protected List d()
  {
    return getContainer().getEnvionment().getClassMembers(this, true);
  }

  protected List e()
  {
    int i = StringUtils.countMatches(getJavaType().K(), "[");
    ArrayList localArrayList = new ArrayList(i + 1);
    g localg = getJavaType();
    for (int j = 0; j < i; j++)
    {
      localArrayList.add(new SubVariable("get(" + j + ")", localg.J().K(), a(j), getDisplayName() + a(j), a(getParams(), "int")));
      localg = localg.J();
    }
    localArrayList.add(new SubFunction("length", "int", ".length", getDisplayName() + ".length", getParams()));
    return localArrayList;
  }

  private String a(int paramInt)
  {
    String str = "";
    for (int i = 0; i <= paramInt; i++)
      str = str + "[{arg" + (getParams().size() + 1 + i) + "}]";
    return str;
  }

  private List f()
  {
    ArrayList localArrayList = new ArrayList(40);
    localArrayList.add(new SubFunction("getObj(int)", getJavaType().J().K(), getTypeManager().e(getJavaType().J()), ".get({arg" + (getParams().size() + 1) + "})" + getTypeManager().f(getJavaType().J()), getDisplayName() + ".get({arg" + (getParams().size() + 1) + "})", a(getParams(), "int")));
    localArrayList.add(new SubFunction("addObj(" + getJavaType().J().K() + ")", "void", ".add(" + getTypeManager().g(getJavaType().J()) + "{" + "arg" + (getParams().size() + 1) + "}" + getTypeManager().h(getJavaType().J()) + ")", getDisplayName() + ".add({arg" + (getParams().size() + 1) + "})", a(getParams(), getJavaType().J().K())));
    localArrayList.add(new SubFunction("removePos(int)", getJavaType().J().K(), getTypeManager().e(getJavaType().J()), ".remove({arg" + (getParams().size() + 1) + "})" + getTypeManager().f(getJavaType().J()), getDisplayName() + ".remove({arg" + (getParams().size() + 1) + "})", a(getParams(), "int")));
    localArrayList.add(new SubFunction("addObj(int," + getJavaType().J().K() + ")", "void", ".add({arg" + (getParams().size() + 1) + "}," + getTypeManager().g(getJavaType().J()) + "{" + "arg" + (getParams().size() + 2) + "}" + getTypeManager().h(getJavaType().J()) + ")", getDisplayName() + ".add({arg" + (getParams().size() + 1) + "},{arg" + (getParams().size() + 2) + "})", a(a(getParams(), "int"), getJavaType().J().K())));
    localArrayList.add(new SubFunction("indexOfObj(" + getJavaType().J().K() + ")", "int", ".indexOf(" + getTypeManager().g(getJavaType().J()) + "{" + "arg" + (getParams().size() + 1) + "}" + getTypeManager().h(getJavaType().J()) + ")", getDisplayName() + ".indexOf({arg" + (getParams().size() + 1) + "})", a(getParams(), getJavaType().J().K())));
    localArrayList.add(new SubFunction("removeObj(" + getJavaType().J().K() + ")", "void", ".remove(" + getTypeManager().g(getJavaType().J()) + "{" + "arg" + (getParams().size() + 1) + "}" + getTypeManager().h(getJavaType().J()) + ")", getDisplayName() + ".remove({arg" + (getParams().size() + 1) + "})", a(getParams(), getJavaType().J().K())));
    localArrayList.addAll(d());
    getContainer().getEnvionment().removeMember(this, localArrayList);
    return localArrayList;
  }

  private List a(List paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramList.size() + 1);
    localArrayList.addAll(paramList);
    localArrayList.add(new MethodParam(paramString, paramList.size()));
    return localArrayList;
  }

  private List a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new MethodParam(paramString, paramInt));
    return localArrayList;
  }

  private List a(int paramInt1, String paramString, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(1);
    for (int i = 0; i <= paramInt2; i++)
      localArrayList.add(new MethodParam(paramString, paramInt1 + i));
    return localArrayList;
  }

  public void changeDisplayName(String paramString1, String paramString2)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IBusinessObjectEditen))
        continue;
      String str = ((IBusinessObjectEditen)localList.get(i)).getDisplayName();
      ((IBusinessObjectEditen)localList.get(i)).setDisplayName(StringUtil.replace(paramString1, paramString2, ((IBusinessObjectEditen)localList.get(i)).getDisplayName()));
      ((IBusinessObjectEditen)localList.get(i)).changeDisplayName(str, ((IBusinessObjectEditen)localList.get(i)).getDisplayName());
    }
    setDisplayName(paramString2);
  }

  public String getShowGroupName()
  {
    if ((this.groupName == null) || (this.groupName.equals("p")))
    {
      if ((getParent() != null) && ((getParent() instanceof IBusinessObjectEditen)))
      {
        if (((getParent() instanceof IBOAndContainer)) || ((getParent() instanceof IExcelObject)))
          return getLocalString("function.text");
        return ((IBusinessObjectEditen)getParent()).getShowGroupName();
      }
      return "";
    }
    return this.groupName;
  }

  public void setShowGroupName(String paramString)
  {
    this.groupName = paramString;
  }

  public boolean isGroupEditable()
  {
    return true;
  }

  public String getGroupName()
  {
    return this.groupName;
  }

  public void setGroupName(String paramString)
  {
    this.groupName = paramString;
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.AbstractBOEditen
 * JD-Core Version:    0.6.0
 */