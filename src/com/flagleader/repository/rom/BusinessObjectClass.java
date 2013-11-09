package com.flagleader.repository.rom;

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
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.lang.info.InfoClass;
import com.flagleader.repository.lang.info.InfoMember;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.util.StringUtil;
import com.flagleader.util.collection.IIterator;
import com.flagleader.util.exception.UnsupportOperationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BusinessObjectClass extends AbstractBOEditen
  implements IClassObject
{
  private transient B clazz = null;
  private String className = null;
  private String shortClassName = null;
  private String dir = null;
  private transient HashMap memberNames = null;

  public BusinessObjectClass()
  {
    if (this.memberNames == null)
      this.memberNames = new HashMap();
    setVisible(false);
  }

  public BusinessObjectClass(BusinessObjectClass paramBusinessObjectClass)
  {
    super(paramBusinessObjectClass);
    if (this.memberNames == null)
      this.memberNames = new HashMap();
    this.className = paramBusinessObjectClass.className;
    this.shortClassName = paramBusinessObjectClass.shortClassName;
    this.dir = paramBusinessObjectClass.dir;
    this.clazz = paramBusinessObjectClass.clazz;
  }

  public BusinessObjectClass(String paramString1, String paramString2)
  {
    if (this.memberNames == null)
      this.memberNames = new HashMap();
    setVisible(false);
    this.dir = paramString1;
    this.className = paramString2;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitBusinessObjectClass(this);
  }

  public void reload()
  {
    if ((getContainer() != null) && ((getContainer() instanceof ClassContainer)))
    {
      B localB = getContainer().getEnvionment().getClassInfo(this.dir, this.className);
      setClazz(localB);
      h();
      getContainer().updateViewer();
    }
  }

  public B getClazz()
  {
    if ((this.clazz == null) && (getContainer() != null) && ((getContainer() instanceof ClassContainer)))
      try
      {
        B localB = getContainer().getEnvionment().getClassInfo(this.dir, this.className);
        setClazz(localB);
      }
      catch (Exception localException)
      {
      }
    return this.clazz;
  }

  public void setClazz(B paramB)
  {
    this.clazz = paramB;
    setClassName(paramB.K());
    setShortClassName(paramB.N());
    if (getDisplayName().length() == 0)
    {
      InfoClass localInfoClass = com.flagleader.repository.lang.info.a.b().b(this.clazz.V());
      if ((localInfoClass != null) && (localInfoClass.getDisplayName().length() > 0))
        setDisplayName(localInfoClass.getDisplayName());
      else
        setDisplayName(paramB.G());
    }
    this.clazz.a(isVisible());
  }

  public void fillAllMembers()
  {
    h();
    g();
  }

  protected IIterator f()
  {
    return n.b(this.clazz.E(), new b(this));
  }

  private void g()
  {
    T localT = n.b(this.clazz.E(), new a(this));
    InfoClass localInfoClass = com.flagleader.repository.lang.info.a.b().b(this.clazz.V());
    while (localT.hasNext())
    {
      M localM = (M)localT.next();
      Object localObject = getMemberToken(localM.I());
      if (localObject == null)
      {
        if ((localM instanceof F))
        {
          localObject = new BusinessObjectConstructor(getDisplayName() + "." + localM.G());
        }
        else if ((localM instanceof P))
        {
          localObject = new BusinessObjectMethod(getDisplayName() + "." + localM.G());
        }
        else
        {
          if (!(localM instanceof y))
            break;
          localObject = new BusinessObjectAttribute(getDisplayName() + "." + localM.G());
        }
        addChildElement((IElement)localObject);
        ((BusinessObjectMember)localObject).setMember(localM, 0);
        if (localInfoClass != null)
        {
          InfoMember localInfoMember = localInfoClass.getMember(localM.I());
          if (localInfoMember != null)
            ((BusinessObjectMember)localObject).setDisplayName(StringUtil.replace("{p}", getDisplayName(), localInfoMember.getDisplayName()));
        }
        a((BusinessObjectMember)localObject);
        if (getContainer() == null)
          continue;
        getContainer().setModified(true);
      }
      else
      {
        ((BusinessObjectMember)localObject).setMember(localM, 0);
      }
    }
  }

  private void h()
  {
    if ((this.clazz == null) || (this.memberNames.size() == 0))
      return;
    HashMap localHashMap = new HashMap();
    IIterator localIIterator = f();
    while (localIIterator.hasNext())
    {
      M localM = (M)localIIterator.next();
      localHashMap.put(localM.I(), localM.I());
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.memberNames.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localHashMap.containsKey(str))
        continue;
      localArrayList.add((BusinessObjectMember)this.memberNames.get(str));
    }
    for (int i = 0; i < localArrayList.size(); i++)
      removeChildElement((BusinessObjectMember)localArrayList.get(i));
    if ((localArrayList.size() > 0) && (getContainer() != null))
      getContainer().setModified(true);
  }

  public BusinessObjectMember getMemberToken(String paramString)
  {
    return (BusinessObjectMember)this.memberNames.get(paramString);
  }

  public String getClassName()
  {
    return this.className;
  }

  public void setClassName(String paramString)
  {
    this.className = paramString;
  }

  public void removeChildElement(IElement paramIElement)
  {
    if (!a(paramIElement))
      return;
    this.memberNames.remove(((BusinessObjectMember)paramIElement).getMemberName());
    super.removeChildElement((BusinessObjectMember)paramIElement);
  }

  public void addChildElement(IElement paramIElement)
  {
    if (!a(paramIElement))
      return;
    if (((BusinessObjectMember)paramIElement).getMemberName().length() > 0)
      a((BusinessObjectMember)paramIElement);
    super.addChildElement((BusinessObjectMember)paramIElement);
  }

  private void a(BusinessObjectMember paramBusinessObjectMember)
  {
    if (this.memberNames == null)
      this.memberNames = new HashMap();
    this.memberNames.put(paramBusinessObjectMember.getMemberName(), paramBusinessObjectMember);
  }

  protected boolean a(IElement paramIElement)
  {
    return (paramIElement instanceof BusinessObjectMember);
  }

  public g getJavaType()
  {
    return getTypeManager().a(getClassName());
  }

  public IElement deepClone()
  {
    return new BusinessObjectClass(this);
  }

  public String getName()
  {
    return "BusinessObjectClass";
  }

  public String getDir()
  {
    return this.dir;
  }

  public void setDir(String paramString)
  {
    this.dir = paramString;
  }

  public void setShortClassName(String paramString)
  {
    this.shortClassName = paramString;
  }

  public String getShortClassName()
  {
    return this.shortClassName;
  }

  public String getLibraryName()
  {
    return getClassName().substring(0, getClassName().lastIndexOf("."));
  }

  public String getVariableName()
  {
    ClassContainer localClassContainer = getClassContainer();
    if (localClassContainer != null)
      return "((" + getClassName() + ")" + localClassContainer.getVarValue() + ".getCurrentValues())";
    return getShortClassName().substring(0, 1).toLowerCase() + getShortClassName().substring(1);
  }

  public ClassContainer getClassContainer()
  {
    IBusinessObjectContainer localIBusinessObjectContainer = getContainer();
    if ((localIBusinessObjectContainer instanceof ClassContainer))
      return (ClassContainer)localIBusinessObjectContainer;
    return null;
  }

  public String getValueType()
  {
    return getClassName();
  }

  public String getValueName()
  {
    return getShortClassName();
  }

  public void setValueName(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public String getVarValue()
  {
    return getVariableName();
  }

  public List getParams()
  {
    return new ArrayList(0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.BusinessObjectClass
 * JD-Core Version:    0.6.0
 */