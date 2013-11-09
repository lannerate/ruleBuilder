package com.flagleader.repository.tree;

import com.flagleader.a.B;
import com.flagleader.a.F;
import com.flagleader.a.M;
import com.flagleader.a.P;
import com.flagleader.a.T;
import com.flagleader.a.c.n;
import com.flagleader.a.y;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.lang.info.InfoClass;
import com.flagleader.repository.lang.info.InfoMember;
import com.flagleader.repository.lang.info.a;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectConstructor;
import com.flagleader.repository.rom.BusinessObjectMember;
import com.flagleader.repository.rom.BusinessObjectMethod;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.xml.TreeFunction;
import com.flagleader.util.StringUtil;
import com.flagleader.util.collection.IIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterfaceContainer extends AbstractBOContainer
  implements IBusinessObjectContainer, IBusinessObject
{
  public static final String NAME = "InterfaceContainer";
  public static final String DISPLAYNAME = getLocalString("InterfaceContainer.text");
  public static final String COMMONNAME = getLocalString("InterfaceContainer.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("InterfaceContainer", DISPLAYNAME, DISPLAYNAME);
  private transient d updater = null;
  private String interfaceName = "";
  private String initStatement = "";
  private String nodeName = "";

  public InterfaceContainer()
  {
  }

  public InterfaceContainer(InterfaceContainer paramInterfaceContainer)
  {
    super(paramInterfaceContainer);
    this.interfaceName = paramInterfaceContainer.interfaceName;
    this.nodeName = paramInterfaceContainer.nodeName;
    this.initStatement = paramInterfaceContainer.initStatement;
  }

  public InterfaceContainer(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1);
    this.initStatement = paramString3;
    this.interfaceName = paramString2;
    this.nodeName = paramString4;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitInterfaceContainer(this);
  }

  public String getNodeName()
  {
    if ((this.nodeName == null) || (this.nodeName.length() == 0))
      return "interface" + getParent().getElementPos(this);
    return this.nodeName;
  }

  public void setNodeName(String paramString)
  {
    this.nodeName = paramString;
  }

  public IElement deepClone()
  {
    return new InterfaceContainer(this);
  }

  public boolean isLocked()
  {
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return getParent().isLocked();
    return super.isLocked();
  }

  public String getName()
  {
    return "InterfaceContainer";
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
    return this.interfaceName;
  }

  public String getVarValue()
  {
    return getVarName();
  }

  public String getVarName()
  {
    return getNodeName();
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

  public BusinessObjectMethod getTreeFunction(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof BusinessObjectMethod)) && (((BusinessObjectMethod)localObject).getValueName().equals(paramString)))
        return (BusinessObjectMethod)localObject;
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
    updateFunction();
  }

  public void updateFunction()
  {
    try
    {
      B localB = getEnvionment().getClassInfo("", this.interfaceName);
      if (localB != null)
      {
        T localT = null;
        localT = n.b(localB.E(), new ap(this));
        InfoClass localInfoClass = a.b().b(localB.V());
        while (localT.hasNext())
        {
          M localM = (M)localT.next();
          Object localObject;
          if ((localM instanceof P))
          {
            localObject = new BusinessObjectMethod(getDisplayName() + "." + localM.G());
          }
          else if ((localM instanceof F))
          {
            localObject = new BusinessObjectConstructor(getDisplayName() + "." + localM.G());
          }
          else
          {
            if (!(localM instanceof y))
              break;
            localObject = new BusinessObjectAttribute(getDisplayName() + "." + localM.G());
          }
          ((BusinessObjectMember)localObject).setMember(localM, 0);
          if (localInfoClass == null)
            continue;
          InfoMember localInfoMember = localInfoClass.getMember(localM.I());
          if (localInfoMember == null)
            continue;
          ((BusinessObjectMember)localObject).setDisplayName(StringUtil.replace("{p}", getDisplayName(), localInfoMember.getDisplayName()));
          if ((getTreeFunction(((BusinessObjectMember)localObject).getValueName()) != null) || (localInfoMember.getDisplayName().indexOf("{p}") < 0))
            continue;
          addChildElement((IElement)localObject);
        }
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
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

  public String getInterfaceName()
  {
    return this.interfaceName;
  }

  public void setInterfaceName(String paramString)
  {
    this.interfaceName = paramString;
  }

  public String getInitStatement()
  {
    return this.initStatement;
  }

  public void setInitStatement(String paramString)
  {
    this.initStatement = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.InterfaceContainer
 * JD-Core Version:    0.6.0
 */