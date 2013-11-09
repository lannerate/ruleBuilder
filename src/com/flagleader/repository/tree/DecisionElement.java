package com.flagleader.repository.tree;

import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.ElementList;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.collections.k;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.l;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.BusinessObjectConstructor;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.rom.MappingFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlAttribute;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DecisionElement extends AbstractElement
{
  private String elementUuid = "";
  private String uniqueName = "";
  private int pos = 1;
  DecisionElement.DecisionElementSelector a = new DecisionElement.DecisionElementSelector(this);
  protected ArrayList b = null;

  public DecisionElement()
  {
  }

  public DecisionElement(DecisionElement paramDecisionElement)
  {
    super(paramDecisionElement);
    this.elementUuid = paramDecisionElement.elementUuid;
    this.uniqueName = paramDecisionElement.uniqueName;
    this.pos = paramDecisionElement.pos;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitDecisionElement(this);
  }

  public IElement deepClone()
  {
    return new DecisionElement(this);
  }

  public String getName()
  {
    return "DecisionElement";
  }

  public String getElementUuid()
  {
    return this.elementUuid;
  }

  public void setElementUuid(String paramString)
  {
    this.elementUuid = paramString;
  }

  public String getUniqueName()
  {
    return this.uniqueName;
  }

  public void setUniqueName(String paramString)
  {
    this.uniqueName = paramString;
  }

  public boolean setMemberElement(IBusinessObject paramIBusinessObject)
  {
    if (paramIBusinessObject == null)
      return false;
    if (!paramIBusinessObject.equals(getMemberElement()))
    {
      this.elementUuid = paramIBusinessObject.getUuid();
      a(paramIBusinessObject);
      return true;
    }
    return false;
  }

  public IBusinessObject getMemberElement()
  {
    IBusinessObject localIBusinessObject = null;
    if ((getElementUuid().length() > 0) || (getUniqueName().length() > 0))
      localIBusinessObject = d();
    if (localIBusinessObject != null)
    {
      if (!localIBusinessObject.getUuid().equals(getElementUuid()))
      {
        setElementUuid(localIBusinessObject.getUuid());
        if ((getParent() != null) && ((getParent() instanceof IRuleTree)))
          ((IRuleTree)getParent()).setNeedSave();
      }
      a(localIBusinessObject);
    }
    return localIBusinessObject;
  }

  protected void a(IBusinessObject paramIBusinessObject)
  {
    if ((paramIBusinessObject instanceof IBusinessObject))
      setUniqueName(paramIBusinessObject.getUniqueName());
  }

  protected IBusinessObject d()
  {
    IBusinessObject localIBusinessObject = null;
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
      localIBusinessObject = localEnvionment.getBusinessObject(getElementUuid(), getUniqueName());
    if ((localIBusinessObject instanceof IBusinessObject))
      return (IBusinessObject)localIBusinessObject;
    return null;
  }

  public g getJavaType()
  {
    if ((d() != null) && ((d() instanceof IBusinessObject)))
      return d().getJavaType();
    return getTypeManager().a("");
  }

  public Envionment getEnvionment()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleTree)))
      return ((IRuleTree)getParent()).getEnvionment();
    return null;
  }

  public int getPos()
  {
    return this.pos;
  }

  public void setPos(int paramInt)
  {
    this.pos = paramInt;
  }

  public boolean canPasteObject(Object paramObject)
  {
    return paramObject instanceof IVariableObject;
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    if ((paramObject instanceof IVariableObject))
    {
      setMemberElement((IVariableObject)paramObject);
      return true;
    }
    return false;
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
        return true;
      if (((localIBusinessObjectEditen instanceof IClassObject)) && (!(localIBusinessObjectEditen instanceof FunctionClass)))
        return false;
    }
    return false;
  }

  public boolean canIncludeSheetField()
  {
    if ((getParent() instanceof IRuleTree))
      return ((IRuleTree)getParent()).canIncludeSheet();
    return false;
  }

  public IRuleTree getRuleTree()
  {
    if ((getParent() instanceof IRuleTree))
      return (IRuleTree)getParent();
    return null;
  }

  public List getWhileSheets()
  {
    if (((getParent() instanceof IRuleTree)) && (((IRuleTree)getParent()).hasSheetWhile()))
      return ((IRuleTree)getParent()).getAllWhileSheets();
    return null;
  }

  protected Iterator e()
  {
    if (canIncludeSheetField())
      return new k(new k(new k(new k(getEnvionment().getAssignVariables(), getEnvionment().getAllSheetVariables()), getEnvionment().getAllExcelVariables()), getEnvionment().getAllXmlVariables()), getEnvionment().getAllSoapVariables());
    List localList = getWhileSheets();
    if ((localList != null) && (localList.size() > 0))
    {
      k localk = new k(getEnvionment().getAssignVariables(), getEnvionment().getAllExcelVariables());
      for (int i = 0; i < localList.size(); i++)
        localk = new k(localk, ((IWhileObject)localList.get(i)).getFieldIterator());
      return new k(new k(localk, getEnvionment().getAllXmlVariables()), getEnvionment().getAllSoapVariables());
    }
    return new k(new k(new k(getEnvionment().getAssignVariables(), getEnvionment().getAllExcelVariables()), getEnvionment().getAllXmlVariables()), getEnvionment().getAllSoapVariables());
  }

  public l[] getLeftPopupMenus()
  {
    List localList = null;
    localList = a(e());
    ArrayList localArrayList = new ArrayList(localList.size());
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof ElementList))
      {
        ElementList localElementList = (ElementList)localList.get(i);
        if (localElementList.size() <= 0)
          continue;
        l locall = new l(localElementList.getDisplayName(), new i(this, localElementList.getElement()), localElementList.getElement());
        localArrayList.add(locall);
        a(locall, localElementList);
      }
      else
      {
        localArrayList.add(new l(((IElement)localList.get(i)).getDisplayName(), new i(this, (IElement)localList.get(i)), (IElement)localList.get(i)));
      }
    l[] arrayOfl = new l[localArrayList.size()];
    for (i = 0; i < localArrayList.size(); i++)
      arrayOfl[i] = ((l)localArrayList.get(i));
    return arrayOfl;
  }

  protected List a(Iterator paramIterator)
  {
    if (this.b == null)
      this.b = new ArrayList();
    else
      this.b.clear();
    while (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      if (!(localObject instanceof IBusinessObjectEditen))
        continue;
      if (((IBusinessObjectEditen)localObject).getContainer() == null)
      {
        if (!StringUtil.isEmpty(((IBusinessObjectEditen)localObject).getShowGroupName()))
          a(((IBusinessObjectEditen)localObject).getShowGroupName()).add((IBusinessObjectEditen)localObject);
        else
          this.b.add(localObject);
      }
      else
        a((IBusinessObjectEditen)localObject);
    }
    for (int i = 0; i < this.b.size(); i++)
    {
      if ((!(this.b.get(i) instanceof ElementList)) || (((ElementList)this.b.get(i)).getElement() == null))
        continue;
      a((ElementList)this.b.get(i));
    }
    return this.b;
  }

  private void a(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    a(paramIBusinessObjectEditen.getContainer()).add(paramIBusinessObjectEditen);
  }

  protected ElementList a(String paramString)
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      if (((this.b.get(j) instanceof ElementList)) && (((ElementList)this.b.get(j)).getElement() == null) && (((ElementList)this.b.get(j)).getDisplayName().equals(paramString)))
        return (ElementList)this.b.get(j);
    ElementList localElementList = new ElementList(paramString);
    this.b.add(localElementList);
    return localElementList;
  }

  protected ElementList a(IBusinessObjectContainer paramIBusinessObjectContainer)
  {
    Object localObject1;
    Object localObject2;
    ElementList localElementList2;
    if ((paramIBusinessObjectContainer instanceof TreeValueNode))
    {
      localObject1 = (TreeValueNode)paramIBusinessObjectContainer;
      if (!((TreeValueNode)localObject1).isRootElement())
      {
        localObject2 = ((TreeValueNode)localObject1).getRootElement();
        localElementList2 = a((IBusinessObjectContainer)localObject2);
        for (int k = 0; k < localElementList2.size(); k++)
          if (((localElementList2.get(k) instanceof ElementList)) && (((ElementList)localElementList2.get(k)).getElement() != null) && (((ElementList)localElementList2.get(k)).getElement().equals(paramIBusinessObjectContainer)))
            return (ElementList)localElementList2.get(k);
        ElementList localElementList3 = new ElementList(paramIBusinessObjectContainer);
        localElementList2.add(localElementList3);
        return localElementList3;
      }
    }
    else if ((paramIBusinessObjectContainer instanceof XmlNode))
    {
      localObject1 = (XmlNode)paramIBusinessObjectContainer;
      if (!((XmlNode)localObject1).isRootElement())
      {
        localObject2 = ((XmlNode)localObject1).getRootElement();
        localElementList2 = a((IBusinessObjectContainer)localObject2);
        for (int m = 0; m < localElementList2.size(); m++)
          if (((localElementList2.get(m) instanceof ElementList)) && (((ElementList)localElementList2.get(m)).getElement() != null) && (((ElementList)localElementList2.get(m)).getElement().equals(paramIBusinessObjectContainer)))
            return (ElementList)localElementList2.get(m);
        ElementList localElementList4 = new ElementList(paramIBusinessObjectContainer);
        localElementList2.add(localElementList4);
        return localElementList4;
      }
    }
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      if (((this.b.get(j) instanceof ElementList)) && (((ElementList)this.b.get(j)).getElement() != null) && (((ElementList)this.b.get(j)).getElement().equals(paramIBusinessObjectContainer)))
        return (ElementList)this.b.get(j);
    ElementList localElementList1 = new ElementList(paramIBusinessObjectContainer);
    this.b.add(localElementList1);
    return (ElementList)(ElementList)localElementList1;
  }

  private int a(ElementList paramElementList, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    int i = 0;
    for (int j = 0; j < paramElementList.size(); j++)
    {
      if ((!(paramElementList.get(j) instanceof IBusinessObjectEditen)) || (!b((IBusinessObjectEditen)paramElementList.get(j)).equals(b(paramIBusinessObjectEditen))))
        continue;
      i++;
    }
    return i;
  }

  private IBusinessObjectEditen b(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    for (IBusinessObjectEditen localIBusinessObjectEditen = paramIBusinessObjectEditen; ((localIBusinessObjectEditen.getParent() instanceof IBusinessObjectEditen)) && (!(localIBusinessObjectEditen.getParent() instanceof IBusinessObjectContainer)); localIBusinessObjectEditen = (IBusinessObjectEditen)localIBusinessObjectEditen.getParent());
    return localIBusinessObjectEditen;
  }

  private void a(ElementList paramElementList)
  {
    Object localObject1;
    Object localObject2;
    for (int i = 0; i < paramElementList.size(); i++)
    {
      if ((!(paramElementList.get(i) instanceof IBusinessObjectEditen)) || (a(paramElementList, (IBusinessObjectEditen)paramElementList.get(i)) <= 1))
        continue;
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramElementList.get(i);
      localObject1 = b(localIBusinessObjectEditen);
      localObject2 = new ElementList((IElement)localObject1);
      for (int k = i; k < paramElementList.size(); k++)
      {
        if ((!(paramElementList.get(k) instanceof IBusinessObjectEditen)) || (!b((IBusinessObjectEditen)paramElementList.get(k)).equals(localObject1)))
          continue;
        ((ElementList)localObject2).add((IBusinessObjectEditen)paramElementList.get(k));
        paramElementList.remove(k--);
      }
      paramElementList.add(i, (IElement)localObject2);
    }
    HashMap localHashMap = new HashMap();
    for (int j = 0; j < paramElementList.size(); j++)
      if ((paramElementList.get(j) instanceof IBusinessObjectEditen))
      {
        localObject1 = (IBusinessObjectEditen)paramElementList.get(j);
        if (((IBusinessObjectEditen)localObject1).getShowGroupName().length() <= 0)
          continue;
        paramElementList.remove(j--);
        localObject2 = (ElementList)localHashMap.get(((IBusinessObjectEditen)localObject1).getShowGroupName());
        if (localObject2 == null)
        {
          localObject2 = new ElementList(((IBusinessObjectEditen)localObject1).getShowGroupName());
          localHashMap.put(((IBusinessObjectEditen)localObject1).getShowGroupName(), localObject2);
          j++;
          paramElementList.add(j, (IElement)localObject2);
        }
        if (localObject2 == null)
          continue;
        ((ElementList)localObject2).add((IElement)localObject1);
      }
      else
      {
        if (!(paramElementList.get(j) instanceof ElementList))
          continue;
        localObject1 = (ElementList)paramElementList.get(j);
        if ((((ElementList)localObject1).getElement() == null) || (!(((ElementList)localObject1).getElement() instanceof IBusinessObjectEditen)))
          continue;
        localObject2 = (IBusinessObjectEditen)((ElementList)localObject1).getElement();
        if (((IBusinessObjectEditen)localObject2).getShowGroupName().length() <= 0)
          continue;
        paramElementList.remove(j--);
        ElementList localElementList = (ElementList)localHashMap.get(((IBusinessObjectEditen)localObject2).getShowGroupName());
        if (localElementList == null)
        {
          localElementList = new ElementList(((IBusinessObjectEditen)localObject2).getShowGroupName());
          localHashMap.put(((IBusinessObjectEditen)localObject2).getShowGroupName(), localElementList);
          j++;
          paramElementList.add(j, localElementList);
        }
        if (localElementList == null)
          continue;
        localElementList.add((IElement)localObject1);
      }
  }

  protected void a(l paraml, ElementList paramElementList)
  {
    IElement[] arrayOfIElement = paramElementList.toArray();
    for (int i = 0; i < arrayOfIElement.length; i++)
      if ((arrayOfIElement[i] instanceof ElementList))
      {
        l locall = new l(((ElementList)arrayOfIElement[i]).getDisplayName(), new i(this, ((ElementList)arrayOfIElement[i]).getElement()), ((ElementList)arrayOfIElement[i]).getElement());
        a(locall, (ElementList)arrayOfIElement[i]);
        paraml.a(locall);
      }
      else
      {
        paraml.a(new l(arrayOfIElement[i].getDisplayName(), new i(this, arrayOfIElement[i]), arrayOfIElement[i]));
      }
  }

  public String getColorType()
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    if (localIBusinessObject == null)
      return "empty";
    if ((localIBusinessObject instanceof BusinessObjectClass))
      return "class";
    if ((localIBusinessObject instanceof BusinessObjectAttribute))
      return "classAttribute";
    if ((localIBusinessObject instanceof BusinessObjectConstructor))
      return "classConstructor";
    if ((localIBusinessObject instanceof ConstantEnum))
      return "constant";
    if ((localIBusinessObject instanceof MappingVariable))
      return "inoutVariable";
    if ((localIBusinessObject instanceof TempVariable))
      return "tempVariable";
    if ((localIBusinessObject instanceof MappingFunction))
      return "staticFunction";
    if ((localIBusinessObject instanceof GlobalFunction))
      return "staticFunction";
    if ((localIBusinessObject instanceof FunctionMember))
      return "customFunction";
    if ((localIBusinessObject instanceof SheetFieldModel))
      return "sheetField";
    if ((localIBusinessObject instanceof MapValue))
      return "sheetField";
    if ((localIBusinessObject instanceof XmlAttribute))
      return "xmlFunction";
    if ((localIBusinessObject instanceof TreeAttribute))
      return "treeFunction";
    if ((localIBusinessObject instanceof AbstractExcelFieldModel))
      return "excelFunction";
    if ((localIBusinessObject instanceof SoapParameter))
      return "soapFunction";
    return "default";
  }

  public DecisionElement.DecisionElementSelector getContainer()
  {
    return this.a;
  }

  public String getDisplayName()
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    if (localIBusinessObject != null)
      return localIBusinessObject.getDisplayName();
    return super.getDisplayName();
  }

  public String getShowDisplayName()
  {
    if (getDisplayName().length() > 0)
      return getDisplayName();
    return getLocalString("selectMember.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.DecisionElement
 * JD-Core Version:    0.6.0
 */