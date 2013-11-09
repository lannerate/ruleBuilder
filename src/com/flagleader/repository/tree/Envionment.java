package com.flagleader.repository.tree;

import com.flagleader.a.c.n;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.ElementList;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.collections.c;
import com.flagleader.repository.collections.k;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.e.e;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.lang.info.InfoClass;
import com.flagleader.repository.lang.info.InfoMember;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.BusinessObjectConstructor;
import com.flagleader.repository.rom.BusinessObjectMember;
import com.flagleader.repository.rom.BusinessObjectMethod;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.rom.MappingFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.soap.SoapFunction;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.xml.TreeFunction;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlFunction;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.StringUtil;
import com.flagleader.util.collection.IIterator;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Envionment extends AbstractPackageElement
  implements IEnvionment
{
  public static final String NAME = "Envionment";
  public static final String DISPLAYNAME = getLocalString("Envionment.text");
  public static final String COMMONNAME = getLocalString("Envionment.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("Envionment", DISPLAYNAME, DISPLAYNAME);
  public static final String FILEEXT = ".env";
  private int functionNum = 1;
  private List classDirs = new ArrayList(2);
  private long autoSaveTime = 0L;
  private transient com.flagleader.repository.d.a bomClassLoader;
  private HashMap uuidMap;
  private HashMap uniqueMap;
  private HashMap disNameMap = null;
  private transient String filePathName = "";
  private transient com.flagleader.a.b.g objectModel = new com.flagleader.a.b.g();
  private long getRelateVarNamesTime = 0L;
  private ArrayList relateVars = null;
  private long getAllVarsTime = 0L;
  private ArrayList allVars = null;
  private long getAllRuleElementTime = 0L;
  private ArrayList allRules = null;

  public Envionment(Envionment paramEnvionment)
  {
    super(paramEnvionment);
    this.functionNum = paramEnvionment.functionNum;
  }

  public Envionment(String paramString)
  {
    super(paramString);
  }

  public Envionment()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitEnvionment(this);
  }

  public IElement deepClone()
  {
    return new Envionment(this);
  }

  public static Envionment getEmptyEnvionment()
  {
    Envionment localEnvionment = new Envionment(COMMONNAME);
    localEnvionment.addChildElement(ValueLibrary.getCommonLibrary());
    localEnvionment.addChildElement(VariableLibrary.getCommonLibrary());
    localEnvionment.addChildElement(FunctionLibrary.getCommonLibrary());
    localEnvionment.addChildElement(EnumLibrary.getCommonLibrary());
    return localEnvionment;
  }

  public void replaceNewEnvionment(Envionment paramEnvionment)
  {
    clearAllChildren();
    List localList = paramEnvionment.a();
    for (int i = 0; i < localList.size(); i++)
      addChildElement((IElement)localList.get(i));
    setModified(true);
  }

  public FunctionLibrary getFunctionLibrary()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof FunctionLibrary))
        return (FunctionLibrary)localObject;
    }
    return null;
  }

  public EnumLibrary getEnumLibrary()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof EnumLibrary))
        return (EnumLibrary)localObject;
    }
    return null;
  }

  public VariableLibrary getTempVariableLibrary()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof VariableLibrary))
        return (VariableLibrary)localObject;
    }
    return null;
  }

  public ValueLibrary getValueLibrary()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof ValueLibrary))
        return (ValueLibrary)localObject;
    }
    return null;
  }

  public IPage getModelExport()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof IPage))
        return (IPage)localObject;
    }
    return null;
  }

  public Iterator getCustomFunction()
  {
    return getAcceptChildren(new r(this));
  }

  public Iterator getDBModels()
  {
    return getAcceptChildren(new C(this));
  }

  public Iterator getExcelBookModels()
  {
    return getAcceptChildren(new N(this));
  }

  public void updateTableDisplayNames()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof DBModel))
        continue;
      ((DBModel)localObject).updateDisplayNames();
    }
  }

  public Iterator getSoapServices()
  {
    return getAcceptChildren(new Y(this));
  }

  public Iterator getClassContainers()
  {
    return getAcceptChildren(new ae(this));
  }

  public Iterator getInterfaceContainers()
  {
    return getAcceptChildren(new af(this));
  }

  public Iterator getXmlNodes()
  {
    return getAcceptChildren(new ag(this));
  }

  public Iterator getTreeNodes()
  {
    return getAcceptChildren(new ah(this));
  }

  public Iterator getSheetTables()
  {
    return getAcceptElements(new ai(this));
  }

  public Iterator getSheetMaps()
  {
    return getAcceptElements(new s(this));
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return ((paramITreeNode instanceof IRuleTree)) || ((paramITreeNode instanceof BOContainerGroup)) || ((paramITreeNode instanceof CustomFunction)) || ((paramITreeNode instanceof DBModel)) || ((paramITreeNode instanceof XmlNode)) || ((paramITreeNode instanceof SoapService)) || ((paramITreeNode instanceof IPage)) || ((paramITreeNode instanceof TreeValueNode)) || ((paramITreeNode instanceof SheetTable)) || ((paramITreeNode instanceof ExcelBookModel)) || ((paramITreeNode instanceof ClassContainer)) || ((paramITreeNode instanceof InterfaceContainer));
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("RuleSet")) || (paramString.equals("RuleSetFlow")) || (paramString.equals("Rule")) || (paramString.equals("BOContainerGroup")) || (paramString.equals("DecisionRule")) || (paramString.equals("DecisionMultiRule")) || (paramString.equals("DecisionRelateRule")) || (paramString.equals("SoapService")) || (paramString.equals("CustomFunction")) || (paramString.equals("DBModel")) || (paramString.equals("xmlNode")) || (paramString.equals("SheetTable")) || (paramString.equals("ExcelBookModel")) || (paramString.equals("TreeValueNode")) || (paramString.equals("ClassContainer")) || (paramString.equals("InterfaceContainer")) || (paramString.equals("ExpressionRule"));
  }

  public ITreeNode createChildNode(String paramString)
  {
    Object localObject;
    if (paramString.equalsIgnoreCase("RuleSet"))
    {
      localObject = null;
      if (d())
        localObject = new RuleSet(getChildDefaultName(RuleSet.DISPLAYNAME));
      else
        localObject = new RuleSet(getChildDefaultName(RuleSet.COMMNAME));
      addChildElement((IElement)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RuleSetFlow"))
    {
      localObject = null;
      if (d())
        localObject = new RuleSetFlow(getChildDefaultName(RuleSetFlow.DISPLAYNAME));
      else
        localObject = new RuleSetFlow(getChildDefaultName(RuleSetFlow.COMMNAME));
      addChildElement((IElement)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("Rule"))
    {
      localObject = null;
      if (d())
        localObject = new Rule(getChildDefaultName(Rule.DISPLAYNAME));
      else
        localObject = new Rule(getChildDefaultName(Rule.COMMNAME));
      addChildElement((IElement)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionRule"))
    {
      localObject = null;
      if (d())
        localObject = new DecisionRule(getChildDefaultName(DecisionRule.DISPLAYNAME));
      else
        localObject = new DecisionRule(getChildDefaultName(DecisionRule.COMMNAME));
      addChildElement((IElement)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionMultiRule"))
    {
      localObject = null;
      if (d())
        localObject = new DecisionMultiRule(getChildDefaultName(DecisionMultiRule.DISPLAYNAME));
      else
        localObject = new DecisionMultiRule(getChildDefaultName(DecisionMultiRule.COMMNAME));
      addChildElement((IElement)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("ExpressionRule"))
    {
      localObject = null;
      if (d())
        localObject = new ExpressionRule(getChildDefaultName(ExpressionRule.DISPLAYNAME));
      else
        localObject = new ExpressionRule(getChildDefaultName(ExpressionRule.COMMNAME));
      addChildElement((IElement)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionRelateRule"))
    {
      localObject = null;
      if (d())
        localObject = new DecisionRelateRule(getChildDefaultName(DecisionRelateRule.DISPLAYNAME));
      else
        localObject = new DecisionRelateRule(getChildDefaultName(DecisionRelateRule.COMMNAME));
      addChildElement((IElement)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("CustomFunction"))
    {
      localObject = new CustomFunction(getChildDefaultName(CustomFunction.DISPLAYNAME));
      addChildElement((IElement)localObject);
      this.functionNum += 1;
      return localObject;
    }
    if (paramString.equalsIgnoreCase("BOContainerGroup"))
    {
      localObject = new BOContainerGroup(getChildDefaultName(BOContainerGroup.DISPLAYNAME));
      addChildElement((IElement)localObject);
      return localObject;
    }
    if (paramString.equals("xmlNode"))
    {
      localObject = new XmlNode(getChildDefaultName(XmlNode.DISPLAYNAME));
      addChildElement((IElement)localObject);
      ((XmlNode)localObject).updateFunction();
      return localObject;
    }
    if (paramString.equals("TreeValueNode"))
    {
      localObject = new TreeValueNode(getChildDefaultName(TreeValueNode.ROOTNAME));
      addChildElement((IElement)localObject);
      ((TreeValueNode)localObject).resetFunction();
      return localObject;
    }
    if (paramString.equals("SoapService"))
    {
      localObject = new SoapService(getChildDefaultName(paramString));
      addChildElement((IElement)localObject);
      ((SoapService)localObject).updateFunction();
      return localObject;
    }
    return (ITreeNode)super.createChildNode(paramString);
  }

  private boolean d()
  {
    return (getParent() != null) && ((getParent() instanceof IRuleProject));
  }

  public boolean canRename()
  {
    return (getParent() == null) || (!(getParent() instanceof IRulePackage));
  }

  public boolean canDelete()
  {
    return (getParent() == null) || (!(getParent() instanceof IRulePackage));
  }

  public Iterator getAcceptNodes()
  {
    if (b())
      return super.getAcceptNodes();
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(RuleSet.nodeInfo);
    localArrayList.add(RuleSetFlow.nodeInfo);
    localArrayList.add(Rule.nodeInfo);
    localArrayList.add(CustomFunction.nodeInfo);
    localArrayList.add(BOContainerGroup.nodeInfo);
    return localArrayList.iterator();
  }

  public Iterator getValueMembers(String paramString, boolean paramBoolean, List paramList)
  {
    return getAcceptElements(new t(this, paramBoolean, paramString, paramList));
  }

  public Iterator getAllVariables(String paramString, boolean paramBoolean, List paramList)
  {
    return getAcceptElements(new u(this, paramString, paramBoolean, paramList));
  }

  public Iterator getAssignVariables()
  {
    return getAcceptElements(new v(this));
  }

  public Iterator getAllSheetVariables()
  {
    return getAcceptElements(new w(this));
  }

  public Iterator getAllExcelVariables()
  {
    return getAcceptElements(new x(this));
  }

  public Iterator getAllXmlVariables()
  {
    return getAcceptElements(new y(this));
  }

  public Iterator getAllTreeVariables()
  {
    return getAcceptElements(new z(this));
  }

  public Iterator getAllSoapVariables()
  {
    return getAcceptElements(new A(this));
  }

  public Iterator getDecisionAssgignVariables()
  {
    return getAcceptElements(new B(this));
  }

  public List getAllTraceVariable()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getAcceptElements(new D(this));
    while (localIterator.hasNext())
      localArrayList.add(localIterator.next());
    return localArrayList;
  }

  public Iterator getAllTestVariable()
  {
    return getAcceptElements(new E(this));
  }

  public Iterator getAllExpressionVariable()
  {
    return getAcceptElements(new F(this));
  }

  public boolean hasSetInOut()
  {
    return getAllInoutVariables().hasNext();
  }

  public String getInoutParameterString(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = getValueLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof MappingVariable)) || ((((MappingVariable)localObject).getInout() & paramInt) <= 0))
        continue;
      localStringBuffer.append(((MappingVariable)localObject).getValueName()).append("|");
    }
    if (localStringBuffer.length() > 0)
      return localStringBuffer.substring(0, localStringBuffer.length() - 1);
    return localStringBuffer.toString();
  }

  public String getInoutString(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = getValueLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof MappingVariable)) || (((MappingVariable)localObject).getInout() != paramInt))
        continue;
      localStringBuffer.append(((MappingVariable)localObject).getValueName()).append("|");
    }
    if (localStringBuffer.length() > 0)
      return localStringBuffer.substring(0, localStringBuffer.length() - 1);
    return localStringBuffer.toString();
  }

  public Iterator getAllMappingVariable()
  {
    return getAcceptElements(new G(this));
  }

  public Iterator getInVariables()
  {
    return getAcceptElements(new H(this));
  }

  public Iterator getAllInoutVariables()
  {
    return getAcceptElements(new I(this));
  }

  public Iterator getOutVariables()
  {
    return getAcceptElements(new J(this));
  }

  public IBusinessObject getBusinessObject(String paramString, boolean paramBoolean, List paramList)
  {
    c localc = new c(getChildrenIterator(), new K(this, paramBoolean, paramString, paramList));
    if (localc.hasNext())
      return (IBusinessObject)localc.next();
    return null;
  }

  public IBusinessObject getBusinessObject(String paramString, List paramList)
  {
    c localc = new c(getChildrenIterator(), new L(this, paramString, paramList));
    if (localc.hasNext())
      return (IBusinessObject)localc.next();
    return null;
  }

  public IWhileObject getSheetTable(String paramString)
  {
    c localc = new c(getChildrenIterator(), new M(this, paramString));
    if (localc.hasNext())
      return (IWhileObject)localc.next();
    return null;
  }

  public IWhileObject getSheetTableByName(String paramString)
  {
    c localc = new c(getChildrenIterator(), new O(this, paramString));
    if (localc.hasNext())
      return (IWhileObject)localc.next();
    return null;
  }

  public IBusinessObject getBusinessDisName(String paramString)
  {
    if (this.disNameMap == null)
    {
      this.disNameMap = new HashMap();
      reRegistAllBusinessObject();
    }
    return (IBusinessObject)this.disNameMap.get(paramString);
  }

  public IBusinessObject getBusinessObject(String paramString1, String paramString2)
  {
    IBusinessObject localIBusinessObject = null;
    if (paramString1 != null)
    {
      localIBusinessObject = (IBusinessObject)getUuidMap().get(paramString1);
      if (localIBusinessObject != null)
        return localIBusinessObject;
    }
    if (paramString2 != null)
    {
      localIBusinessObject = (IBusinessObject)getUniqueMap().get(paramString2);
      if (localIBusinessObject != null)
        return localIBusinessObject;
      if (paramString2.indexOf(", ") > 0)
      {
        paramString2 = StringUtil.replace(", ", ",", paramString2);
        localIBusinessObject = (IBusinessObject)getUniqueMap().get(paramString2);
        if (localIBusinessObject != null)
          return localIBusinessObject;
      }
    }
    return null;
  }

  public IElement getRuleObject(String paramString1, String paramString2)
  {
    Iterator localIterator = getChildrenIterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof IRuleTree)) && (paramString1.length() > 0) && (((IElement)localObject).getUuid().equals(paramString1)))
        return (IElement)localObject;
    }
    localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof IRuleTree)) && (paramString1.length() > 0) && (((IElement)localObject).getDisplayName().equals(paramString2)))
        return (IElement)localObject;
    }
    return null;
  }

  public Iterator getCustomFunctions(String paramString)
  {
    return getAcceptElements(new P(this, paramString));
  }

  public Iterator getEnums(String paramString)
  {
    if (paramString.equalsIgnoreCase("string"))
      return new k(getEnumLibrary().getSystemEnums(), getAcceptElements(new Q(this, paramString)));
    return getAcceptElements(new R(this, paramString));
  }

  public Iterator getEnums(String paramString1, String paramString2)
  {
    return getAcceptElements(new S(this, paramString2, paramString1));
  }

  public Iterator getAllMethod(String paramString, boolean paramBoolean)
  {
    return getAcceptElements(new T(this, paramString, paramBoolean));
  }

  public Iterator getAllTableFunction(String paramString)
  {
    return getAcceptElements(new U(this, paramString));
  }

  public Iterator getAllSoapFunction(String paramString)
  {
    return getAcceptElements(new V(this, paramString));
  }

  public ElementList getSoapFunction(String paramString, SoapService paramSoapService)
  {
    ElementList localElementList = new ElementList(paramSoapService.getDisplayName());
    List localList1 = paramSoapService.getAllNodes();
    for (int i = 0; i < localList1.size(); i++)
      localElementList.add(getSoapFunction(paramString, (SoapService)localList1.get(i)));
    List localList2 = paramSoapService.getAllEditens();
    for (int j = 0; j < localList2.size(); j++)
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)localList2.get(j);
      if ((!localIBusinessObjectEditen.isEditVisible()) || (!(localIBusinessObjectEditen instanceof SoapFunction)) || ((paramString != null) && (paramString.length() != 0) && (!localIBusinessObjectEditen.getJavaType().c(paramString))))
        continue;
      localElementList.add(localIBusinessObjectEditen);
    }
    return localElementList;
  }

  public Iterator getAllXmlFunction(String paramString)
  {
    return getAcceptElements(new W(this, paramString));
  }

  public Iterator getAllTreeFunction(String paramString)
  {
    return getAcceptElements(new X(this, paramString));
  }

  public ElementList getXmlFunction(String paramString, XmlNode paramXmlNode)
  {
    ElementList localElementList = new ElementList(paramXmlNode.getDisplayName());
    List localList1 = paramXmlNode.getAllNodes();
    for (int i = 0; i < localList1.size(); i++)
      localElementList.add(getXmlFunction(paramString, (XmlNode)localList1.get(i)));
    List localList2 = paramXmlNode.getAllEditens();
    for (int j = 0; j < localList2.size(); j++)
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)localList2.get(j);
      if ((!localIBusinessObjectEditen.isEditVisible()) || (!(localIBusinessObjectEditen instanceof XmlFunction)) || ((paramString != null) && (paramString.length() != 0) && (!localIBusinessObjectEditen.getJavaType().c(paramString))))
        continue;
      localElementList.add(localIBusinessObjectEditen);
    }
    return localElementList;
  }

  public ElementList getTreeFunction(String paramString, TreeValueNode paramTreeValueNode)
  {
    ElementList localElementList = new ElementList(paramTreeValueNode.getDisplayName());
    List localList1 = paramTreeValueNode.getAllNodes();
    for (int i = 0; i < localList1.size(); i++)
      localElementList.add(getTreeFunction(paramString, (TreeValueNode)localList1.get(i)));
    List localList2 = paramTreeValueNode.getAllEditens();
    for (int j = 0; j < localList2.size(); j++)
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)localList2.get(j);
      if ((!localIBusinessObjectEditen.isEditVisible()) || (!(localIBusinessObjectEditen instanceof TreeFunction)) || ((paramString != null) && (paramString.length() != 0) && (!localIBusinessObjectEditen.getJavaType().c(paramString))))
        continue;
      localElementList.add(localIBusinessObjectEditen);
    }
    return localElementList;
  }

  public int getFunctionNum()
  {
    return this.functionNum;
  }

  public void setFunctionNum(int paramInt)
  {
    this.functionNum = paramInt;
  }

  private com.flagleader.a.b.g e()
  {
    return this.objectModel;
  }

  public com.flagleader.a.B getClassInfo(String paramString1, String paramString2)
  {
    addClassDir(paramString1);
    com.flagleader.repository.d.a locala = getBomClassLoader();
    Class localClass = locala.loadClass(paramString2);
    if (localClass == null)
      throw new ClassNotFoundException();
    return getClassInfo(localClass);
  }

  public com.flagleader.a.B getClassInfo(Class paramClass)
  {
    e().a(paramClass);
    com.flagleader.a.B localB = this.objectModel.d(paramClass.getName());
    return localB;
  }

  public com.flagleader.a.B getClassInfo(String paramString)
  {
    return getClassInfo("", paramString);
  }

  public ClassContainer getObjectClass(String paramString)
  {
    for (int i = 0; i < a().size(); i++)
      if (((a().get(i) instanceof ClassContainer)) && (((ClassContainer)a().get(i)).getClassToken(paramString) != null))
        return (ClassContainer)a().get(i);
    return null;
  }

  public ClassContainer loadClass(String paramString1, String paramString2)
  {
    if (getEnvionment() == null)
      return null;
    com.flagleader.a.B localB = getEnvionment().getClassInfo(paramString1, paramString2);
    ClassContainer localClassContainer = getObjectClass(paramString2);
    if (localClassContainer == null)
    {
      BusinessObjectClass localBusinessObjectClass = new BusinessObjectClass(paramString1, paramString2);
      localBusinessObjectClass.setClazz(localB);
      localClassContainer = new ClassContainer(localBusinessObjectClass);
      addChildElement(localClassContainer);
      setModified(true);
      updateTree();
    }
    else
    {
      localClassContainer.getClassToken(paramString2).setClazz(localB);
      localClassContainer.updateViewer();
    }
    return localClassContainer;
  }

  public List getClassMembers(IBusinessObject paramIBusinessObject, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramIBusinessObject.getJavaType().p())
    {
      String str = paramIBusinessObject.getJavaType().K();
      if (str.endsWith(".Runtime"))
        return localArrayList;
      if ((str.equalsIgnoreCase("list")) || (paramIBusinessObject.getJavaType().t()))
        str = "java.util.List";
      else if (str.equalsIgnoreCase("map"))
        str = "java.util.Map";
      else if (str.equalsIgnoreCase("object"))
        str = "java.lang.Object";
      else if (str.equalsIgnoreCase("string"))
        str = "java.lang.String";
      else if (str.equalsIgnoreCase("text"))
        str = "java.lang.String";
      else if (str.equalsIgnoreCase("date"))
        str = "java.util.Date";
      else if (str.equalsIgnoreCase("time"))
        str = "java.util.Date";
      else if (str.equalsIgnoreCase("datetime"))
        str = "java.util.Date";
      else if (str.equalsIgnoreCase("decimal"))
        str = "java.math.BigDecimal";
      else if (str.equalsIgnoreCase("file"))
        str = "java.io.File";
      else if (str.equalsIgnoreCase("xml"))
        str = "com.flagleader.xml.Node";
      else if (str.equalsIgnoreCase("sheet"))
        str = "com.flagleader.db.Sheet";
      else if (str.equalsIgnoreCase("tree"))
        str = "com.flagleader.xml.TreeValue";
      else if (str.equalsIgnoreCase("excel"))
        str = "com.flagleader.excel.IExcelBook";
      try
      {
        com.flagleader.a.B localB = getClassInfo("", str);
        com.flagleader.a.T localT = null;
        if (paramBoolean)
          localT = n.b(localB.E(), new ak(this));
        else
          localT = n.b(localB.E(), new aj(this));
        InfoClass localInfoClass = com.flagleader.repository.lang.info.a.b().b(localB.V());
        while (localT.hasNext())
        {
          com.flagleader.a.M localM = (com.flagleader.a.M)localT.next();
          Object localObject;
          if ((localM instanceof com.flagleader.a.F))
          {
            localObject = new BusinessObjectConstructor(paramIBusinessObject.getDisplayName() + "." + localM.G());
          }
          else if ((localM instanceof com.flagleader.a.P))
          {
            localObject = new BusinessObjectMethod(paramIBusinessObject.getDisplayName() + "." + localM.G());
          }
          else
          {
            if (!(localM instanceof com.flagleader.a.y))
              break;
            localObject = new BusinessObjectAttribute(paramIBusinessObject.getDisplayName() + "." + localM.G());
          }
          ((BusinessObjectMember)localObject).setMember(localM, paramIBusinessObject.getParams().size());
          if (localInfoClass != null)
          {
            InfoMember localInfoMember = localInfoClass.getMember(localM.I());
            if (localInfoMember != null)
              ((BusinessObjectMember)localObject).setDisplayName(StringUtil.replace("{p}", paramIBusinessObject.getDisplayName(), localInfoMember.getDisplayName()));
          }
          if (a(paramIBusinessObject, (IBusinessObject)localObject))
            continue;
          localArrayList.add(localObject);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        EngineLogger.getEngineLogger().warning(localClassNotFoundException.getMessage(), localClassNotFoundException);
      }
    }
    return (List)localArrayList;
  }

  public void removeMember(IBusinessObject paramIBusinessObject, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      if ((!(paramList.get(i) instanceof IBusinessObject)) || (!a(paramIBusinessObject, (IBusinessObject)paramList.get(i))))
        continue;
      paramList.remove(i--);
    }
  }

  private boolean a(IBusinessObject paramIBusinessObject1, IBusinessObject paramIBusinessObject2)
  {
    Iterator localIterator = paramIBusinessObject1.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof IBusinessObject)) && (((IBusinessObject)localObject).getValueName().equals(paramIBusinessObject2.getValueName())))
        return true;
    }
    return false;
  }

  public com.flagleader.a.P getMethodInfo(String paramString1, String paramString2)
  {
    com.flagleader.a.B localB = getClassInfo(paramString1);
    return localB.j().a(paramString2);
  }

  public String getName()
  {
    return "Envionment";
  }

  public void autoSave()
  {
    if ((getParent() instanceof RulePackage))
      ((RulePackage)getParent()).autoSave();
    if ((getParent() instanceof RuleProject))
      ((RuleProject)getParent()).save(this, true);
  }

  public String[] getClassDirs()
  {
    String[] arrayOfString = new String[this.classDirs.size()];
    for (int i = 0; i < this.classDirs.size(); i++)
      arrayOfString[i] = ((String)this.classDirs.get(i));
    return arrayOfString;
  }

  public List getClassDirVector()
  {
    return this.classDirs;
  }

  public void addClassDir(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0) && (!a(paramString)))
      this.classDirs.add(paramString);
  }

  private File[] f()
  {
    File[] arrayOfFile = new File[this.classDirs.size()];
    for (int i = 0; i < this.classDirs.size(); i++)
      arrayOfFile[i] = new File((String)this.classDirs.get(i));
    return arrayOfFile;
  }

  private boolean a(String paramString)
  {
    for (int i = 0; i < this.classDirs.size(); i++)
      if (((String)this.classDirs.get(i)).equals(paramString))
        return true;
    return false;
  }

  public com.flagleader.repository.d.a getBomClassLoader()
  {
    if (this.bomClassLoader == null)
    {
      if (getRepository() == null)
        this.bomClassLoader = new com.flagleader.repository.d.a();
      else
        this.bomClassLoader = new com.flagleader.repository.d.a(getRepository().getBomClassLoader());
      this.objectModel.a(this.bomClassLoader);
    }
    this.bomClassLoader.a(f());
    if (getMainPackage() != null)
    {
      this.bomClassLoader.a(new String[] { getMainPackage().getCompilePath() });
      this.bomClassLoader.a(getMainPackage().getClassPaths());
    }
    return this.bomClassLoader;
  }

  public IRuleRepository getRepository()
  {
    if ((getParent() instanceof RulePackage))
      return ((RulePackage)getParent()).getRepository();
    if ((getParent() instanceof IRuleProject))
      return ((IRuleProject)getParent()).getRepository();
    return null;
  }

  public IBusinessObject exitsChildBusinessObject(IBusinessObject paramIBusinessObject)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      IElement localIElement = (IElement)localList.get(i);
      if (((localIElement instanceof IBusinessObject)) && (localIElement.getName().equals(paramIBusinessObject.getName())) && (((IBusinessObject)localIElement).getValueName().equals(paramIBusinessObject.getValueName())))
        return (IBusinessObject)localIElement;
    }
    return null;
  }

  public boolean pasteEnvionment(Iterator paramIterator)
  {
    while (paramIterator.hasNext())
    {
      IBusinessObject localIBusinessObject = (IBusinessObject)paramIterator.next();
      if ((localIBusinessObject instanceof ConstantEnum))
      {
        if ((getEnumLibrary().exitsEditens(((ConstantEnum)localIBusinessObject).getValueName()) != null) || (!getEnumLibrary().pasteElement(localIBusinessObject, -1)))
          continue;
        getEnumLibrary().updateViewer();
      }
      else if ((localIBusinessObject instanceof MappingVariable))
      {
        if ((getValueLibrary().exitsEditens(((MappingVariable)localIBusinessObject).getValueName()) != null) || (!getValueLibrary().pasteElement(localIBusinessObject, -1)))
          continue;
        getValueLibrary().updateViewer();
      }
      else if ((localIBusinessObject instanceof TempVariable))
      {
        if ((getTempVariableLibrary().exitsEditens(((TempVariable)localIBusinessObject).getValueName()) != null) || (!getTempVariableLibrary().pasteElement(localIBusinessObject, -1)))
          continue;
        getTempVariableLibrary().updateViewer();
      }
      else if (((localIBusinessObject instanceof FunctionClass)) || ((localIBusinessObject instanceof MappingFunction)) || ((localIBusinessObject instanceof GlobalFunction)))
      {
        if ((getFunctionLibrary().exitsEditens(localIBusinessObject.getValueName()) != null) || (!getFunctionLibrary().pasteElement(localIBusinessObject, -1)))
          continue;
        getFunctionLibrary().updateViewer();
      }
      else if (((localIBusinessObject instanceof DBModel)) || ((localIBusinessObject instanceof ClassContainer)) || ((localIBusinessObject instanceof CustomFunction)) || ((localIBusinessObject instanceof InterfaceContainer)) || ((localIBusinessObject instanceof SoapService)) || ((localIBusinessObject instanceof XmlNode)) || ((localIBusinessObject instanceof TreeValueNode)) || ((localIBusinessObject instanceof ExcelSheetModel)))
      {
        if (exitsChildBusinessObject(localIBusinessObject) != null)
          continue;
        super.paste(localIBusinessObject);
      }
      else
      {
        if (((!(localIBusinessObject instanceof SheetTable)) && (!(localIBusinessObject instanceof SheetMap)) && (!(localIBusinessObject instanceof EnumTable))) || (exitsChildBusinessObject(localIBusinessObject) != null))
          continue;
        super.paste(localIBusinessObject);
      }
    }
    return true;
  }

  public boolean paste(IElement paramIElement)
  {
    Object localObject1;
    Object localObject2;
    if (((paramIElement instanceof Envionment)) || (((paramIElement instanceof ElementContainer)) && (((ElementContainer)paramIElement).getChildrenCount() > 0) && ((((ElementContainer)paramIElement).getChildrenList().get(0) instanceof Envionment))))
    {
      localObject1 = null;
      if ((paramIElement instanceof Envionment))
        localObject1 = (Envionment)paramIElement;
      else
        localObject1 = (Envionment)((ElementContainer)paramIElement).getChildrenList().get(0);
      localObject2 = ((Envionment)localObject1).getAcceptElements(new Z(this));
      return pasteEnvionment((Iterator)localObject2);
    }
    if ((paramIElement instanceof IBusinessObjectEditen))
    {
      if (((paramIElement instanceof ConstantEnum)) && (getEnumLibrary().pasteElement(paramIElement, -1)))
      {
        getEnumLibrary().updateViewer();
        return true;
      }
      if (((paramIElement instanceof MappingVariable)) && (getValueLibrary().pasteElement(paramIElement, -1)))
      {
        getValueLibrary().updateViewer();
        return true;
      }
      if (((paramIElement instanceof TempVariable)) && (getTempVariableLibrary().pasteElement(paramIElement, -1)))
      {
        getTempVariableLibrary().updateViewer();
        return true;
      }
      if (getFunctionLibrary().pasteElement(paramIElement, -1))
      {
        getFunctionLibrary().updateViewer();
        return true;
      }
    }
    else if ((paramIElement instanceof ElementContainer))
    {
      localObject1 = ((ElementContainer)paramIElement).getChildrenIterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IElement)((Iterator)localObject1).next();
        if (((localObject2 instanceof ConstantEnum)) && (getEnumLibrary().pasteElement((IElement)localObject2, -1)))
          getEnumLibrary().updateViewer();
        if (((localObject2 instanceof MappingVariable)) && (getValueLibrary().pasteElement((IElement)localObject2, -1)))
          getValueLibrary().updateViewer();
        if (((localObject2 instanceof TempVariable)) && (getTempVariableLibrary().pasteElement((IElement)localObject2, -1)))
          getTempVariableLibrary().updateViewer();
        if (!getFunctionLibrary().pasteElement((IElement)localObject2, -1))
          continue;
        getFunctionLibrary().updateViewer();
      }
    }
    return super.paste(paramIElement);
  }

  public long getAutoSaveTime()
  {
    return this.autoSaveTime;
  }

  public void setAutoSaveTime(long paramLong)
  {
    this.autoSaveTime = paramLong;
  }

  public boolean exitsVarName(String paramString1, String paramString2)
  {
    Iterator localIterator = getValueLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IVariableObject))
        continue;
      IVariableObject localIVariableObject = (IVariableObject)localObject;
      if ((localIVariableObject.getVarValue().equals(paramString1)) && (localIVariableObject.getValueType().equals("string")))
        return true;
    }
    return false;
  }

  public List getRelateVarNames()
  {
    if ((this.getRelateVarNamesTime == getMaxModifyTime()) && (this.relateVars != null))
      return this.relateVars;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getValueLibrary().getChildrenIterator();
    Object localObject;
    IVariableObject localIVariableObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof IVariableObject))
        continue;
      localIVariableObject = (IVariableObject)localObject;
      if ((!localIVariableObject.getJavaType().e()) && (!localIVariableObject.getJavaType().b()) && (!localIVariableObject.getJavaType().m()) && (!localIVariableObject.getJavaType().v()) && (!localIVariableObject.getJavaType().w()) && (!localIVariableObject.getJavaType().x()) && (!localIVariableObject.getJavaType().j()))
        continue;
      localArrayList.add(localIVariableObject);
    }
    localIterator = getTempVariableLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof IVariableObject))
        continue;
      localIVariableObject = (IVariableObject)localObject;
      if ((!localIVariableObject.getJavaType().e()) && (!localIVariableObject.getJavaType().b()) && (!localIVariableObject.getJavaType().m()) && (!localIVariableObject.getJavaType().v()) && (!localIVariableObject.getJavaType().w()) && (!localIVariableObject.getJavaType().x()) && (!localIVariableObject.getJavaType().j()))
        continue;
      localArrayList.add(localIVariableObject);
    }
    this.getRelateVarNamesTime = getMaxModifyTime();
    return localArrayList;
  }

  public String getVarClassName(String paramString)
  {
    Iterator localIterator = getValueLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      if (((IVariableObject)localObject2).getVarValue().equals(paramString))
        return ((IVariableObject)localObject2).getJavaType().L();
    }
    localIterator = getTempVariableLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      if (((IVariableObject)localObject2).getVarValue().equals(paramString))
        return ((IVariableObject)localObject2).getJavaType().L();
    }
    Object localObject1 = getDBModels();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DBModel)((Iterator)localObject1).next();
      localObject3 = ((DBModel)localObject2).getTypeSuperChildren(IBOAndContainer.class);
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (IBOAndContainer)((Iterator)localObject3).next();
        if (((IBOAndContainer)localObject4).getVarValue().equals(paramString))
          return ((IBOAndContainer)localObject4).getValueType();
      }
    }
    localObject1 = getExcelBookModels();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ExcelBookModel)((Iterator)localObject1).next();
      localObject3 = ((ExcelBookModel)localObject2).getTypeSuperChildren(IExcelObject.class);
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (IExcelObject)((Iterator)localObject3).next();
        if (((IExcelObject)localObject4).getVarValue().equals(paramString))
          return ((IExcelObject)localObject4).getValueType();
      }
    }
    Object localObject2 = getXmlNodes();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (XmlNode)((Iterator)localObject2).next();
      if (((XmlNode)localObject3).getVarValue().equals(paramString))
        return ((XmlNode)localObject3).getJavaType().L();
    }
    Object localObject3 = getTreeNodes();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (TreeValueNode)((Iterator)localObject3).next();
      if (((TreeValueNode)localObject4).getVarValue().equals(paramString))
        return ((TreeValueNode)localObject4).getJavaType().L();
    }
    Object localObject4 = getSoapServices();
    Object localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (SoapService)((Iterator)localObject4).next();
      if (((SoapService)localObject5).getVarValue().equals(paramString))
        return ((SoapService)localObject5).getJavaType().L();
    }
    localIterator = getClassContainers();
    Object localObject6;
    while (localIterator.hasNext())
    {
      localObject5 = localIterator.next();
      if (!(localObject5 instanceof ClassContainer))
        continue;
      localObject6 = (ClassContainer)localObject5;
      if (((ClassContainer)localObject6).getVarValue().equals(paramString))
        return ((ClassContainer)localObject6).getValueType();
    }
    localIterator = getInterfaceContainers();
    while (localIterator.hasNext())
    {
      localObject5 = localIterator.next();
      if (!(localObject5 instanceof InterfaceContainer))
        continue;
      localObject6 = (InterfaceContainer)localObject5;
      if (((InterfaceContainer)localObject6).getVarValue().equals(paramString))
        return ((InterfaceContainer)localObject6).getValueType();
    }
    return (String)(String)(String)(String)(String)(String)paramString;
  }

  public String getVarDisplayName(String paramString)
  {
    Iterator localIterator = getValueLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      if (((IVariableObject)localObject2).getShowDisplayName().equals(paramString))
        return ((IVariableObject)localObject2).getJavaType().L();
    }
    localIterator = getTempVariableLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      if (((IVariableObject)localObject2).getShowDisplayName().equals(paramString))
        return ((IVariableObject)localObject2).getJavaType().L();
    }
    Object localObject1 = getDBModels();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DBModel)((Iterator)localObject1).next();
      localObject3 = ((DBModel)localObject2).getTypeSuperChildren(IBOAndContainer.class);
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (IBOAndContainer)((Iterator)localObject3).next();
        if (((IBOAndContainer)localObject4).getShowDisplayName().equals(paramString))
          return ((IBOAndContainer)localObject4).getValueType();
      }
    }
    localObject1 = getExcelBookModels();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ExcelBookModel)((Iterator)localObject1).next();
      localObject3 = ((ExcelBookModel)localObject2).getTypeSuperChildren(IExcelObject.class);
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (IExcelObject)((Iterator)localObject3).next();
        if (((IExcelObject)localObject4).getShowDisplayName().equals(paramString))
          return ((IExcelObject)localObject4).getValueType();
      }
    }
    Object localObject2 = getXmlNodes();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (XmlNode)((Iterator)localObject2).next();
      if (((XmlNode)localObject3).getShowDisplayName().equals(paramString))
        return ((XmlNode)localObject3).getJavaType().L();
    }
    Object localObject3 = getTreeNodes();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (TreeValueNode)((Iterator)localObject3).next();
      if (((TreeValueNode)localObject4).getShowDisplayName().equals(paramString))
        return ((TreeValueNode)localObject4).getJavaType().L();
    }
    Object localObject4 = getSoapServices();
    Object localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (SoapService)((Iterator)localObject4).next();
      if (((SoapService)localObject5).getShowDisplayName().equals(paramString))
        return ((SoapService)localObject5).getJavaType().L();
    }
    localIterator = getClassContainers();
    Object localObject6;
    while (localIterator.hasNext())
    {
      localObject5 = localIterator.next();
      if (!(localObject5 instanceof ClassContainer))
        continue;
      localObject6 = (ClassContainer)localObject5;
      if (((ClassContainer)localObject6).getShowDisplayName().equals(paramString))
        return ((ClassContainer)localObject6).getValueType();
    }
    localIterator = getInterfaceContainers();
    while (localIterator.hasNext())
    {
      localObject5 = localIterator.next();
      if (!(localObject5 instanceof InterfaceContainer))
        continue;
      localObject6 = (InterfaceContainer)localObject5;
      if (((InterfaceContainer)localObject6).getShowDisplayName().equals(paramString))
        return ((InterfaceContainer)localObject6).getValueType();
    }
    return (String)(String)(String)(String)(String)(String)paramString;
  }

  public List getAllVars()
  {
    if ((this.getAllVarsTime == getMaxModifyTime()) && (this.allVars != null))
      return this.allVars;
    this.allVars = new ArrayList();
    Iterator localIterator = getClassContainers();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof ClassContainer))
        continue;
      localObject2 = (ClassContainer)localObject1;
      this.allVars.add(((ClassContainer)localObject2).getVarValue());
    }
    localIterator = getInterfaceContainers();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof InterfaceContainer))
        continue;
      localObject2 = (InterfaceContainer)localObject1;
      this.allVars.add(((InterfaceContainer)localObject2).getVarValue());
    }
    localIterator = getValueLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      this.allVars.add(((IVariableObject)localObject2).getVarValue());
    }
    localIterator = getTempVariableLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      this.allVars.add(((IVariableObject)localObject2).getVarValue());
    }
    this.allVars.add("out");
    Object localObject1 = getDBModels();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DBModel)((Iterator)localObject1).next();
      this.allVars.add(((DBModel)localObject2).getVarName());
      localObject3 = ((DBModel)localObject2).getTypeSuperChildren(IBOAndContainer.class);
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (IBOAndContainer)((Iterator)localObject3).next();
        this.allVars.add(((IBOAndContainer)localObject4).getVarValue());
      }
    }
    localObject1 = getExcelBookModels();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ExcelBookModel)((Iterator)localObject1).next();
      this.allVars.add(((ExcelBookModel)localObject2).getVarValue());
      localObject3 = ((ExcelBookModel)localObject2).getTypeSuperChildren(IExcelObject.class);
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (IExcelObject)((Iterator)localObject3).next();
        this.allVars.add(((IExcelObject)localObject4).getVarValue());
      }
    }
    Object localObject2 = getXmlNodes();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (XmlNode)((Iterator)localObject2).next();
      this.allVars.add(((XmlNode)localObject3).getVarName());
    }
    Object localObject3 = getTreeNodes();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (TreeValueNode)((Iterator)localObject3).next();
      this.allVars.add(((TreeValueNode)localObject4).getVarName());
    }
    Object localObject4 = getSoapServices();
    while (((Iterator)localObject4).hasNext())
    {
      SoapService localSoapService = (SoapService)((Iterator)localObject4).next();
      this.allVars.add(localSoapService.getVarName());
    }
    this.getAllVarsTime = getMaxModifyTime();
    return (List)(List)(List)(List)this.allVars;
  }

  public List getAllVarDisplays()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getClassContainers();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof ClassContainer))
        continue;
      localObject2 = (ClassContainer)localObject1;
      localArrayList.add(((ClassContainer)localObject2).getShowDisplayName());
    }
    localIterator = getInterfaceContainers();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof InterfaceContainer))
        continue;
      localObject2 = (InterfaceContainer)localObject1;
      localArrayList.add(((InterfaceContainer)localObject2).getShowDisplayName());
    }
    localIterator = getValueLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      localArrayList.add(((IVariableObject)localObject2).getShowDisplayName());
    }
    localIterator = getTempVariableLibrary().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof IVariableObject))
        continue;
      localObject2 = (IVariableObject)localObject1;
      localArrayList.add(((IVariableObject)localObject2).getShowDisplayName());
    }
    localArrayList.add("out");
    Object localObject1 = getDBModels();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DBModel)((Iterator)localObject1).next();
      localArrayList.add(((DBModel)localObject2).getVarName());
      localObject3 = ((DBModel)localObject2).getTypeSuperChildren(IBOAndContainer.class);
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (IBOAndContainer)((Iterator)localObject3).next();
        localArrayList.add(((IBOAndContainer)localObject4).getShowDisplayName());
      }
    }
    localObject1 = getExcelBookModels();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ExcelBookModel)((Iterator)localObject1).next();
      localArrayList.add(((ExcelBookModel)localObject2).getShowDisplayName());
      localObject3 = ((ExcelBookModel)localObject2).getTypeSuperChildren(IExcelObject.class);
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (IExcelObject)((Iterator)localObject3).next();
        localArrayList.add(((IExcelObject)localObject4).getShowDisplayName());
      }
    }
    Object localObject2 = getXmlNodes();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (XmlNode)((Iterator)localObject2).next();
      localArrayList.add(((XmlNode)localObject3).getVarName());
    }
    Object localObject3 = getTreeNodes();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (TreeValueNode)((Iterator)localObject3).next();
      localArrayList.add(((TreeValueNode)localObject4).getVarName());
    }
    Object localObject4 = getSoapServices();
    while (((Iterator)localObject4).hasNext())
    {
      SoapService localSoapService = (SoapService)((Iterator)localObject4).next();
      localArrayList.add(localSoapService.getVarName());
    }
    this.getAllVarsTime = getMaxModifyTime();
    return (List)(List)(List)(List)localArrayList;
  }

  public List getAllRuleElement()
  {
    if ((this.getAllRuleElementTime == getMaxModifyTime()) && (this.allRules != null))
      return this.allRules;
    this.allRules = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof IRule))
        this.allRules.add(localObject);
      if (!(localObject instanceof IRuleSet))
        continue;
      this.allRules.addAll(((IRuleSet)localObject).getAllRuleElement());
    }
    this.getAllRuleElementTime = getMaxModifyTime();
    return this.allRules;
  }

  public List getCommonRules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IRuleTree))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public void loadFieldFromExcel(String paramString)
  {
    Object localObject1 = null;
    if (paramString.endsWith(".xls"))
      localObject1 = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(paramString)));
    else
      localObject1 = new XSSFWorkbook(paramString);
    Sheet localSheet = ((Workbook)localObject1).getSheetAt(0);
    String str = "";
    ArrayList localArrayList = new ArrayList();
    Row localRow = localSheet.getRow(0);
    int i = 0;
    int j = 1;
    int k = 2;
    int m = 3;
    int n = 4;
    Cell localCell;
    Object localObject2;
    for (int i1 = 0; i1 < 10; i1++)
    {
      localCell = localRow.getCell(i1);
      if (localCell == null)
        continue;
      localObject2 = localCell.getStringCellValue().toLowerCase();
      if (((String)localObject2).equals("var"))
      {
        i = i1;
      }
      else if (((String)localObject2).equals("type"))
      {
        j = i1;
      }
      else if (((String)localObject2).equals("display"))
      {
        k = i1;
      }
      else if (((String)localObject2).equals("group"))
      {
        m = i1;
      }
      else
      {
        if (!((String)localObject2).equals("pre"))
          continue;
        n = i1;
      }
    }
    for (i1 = 1; i1 < 65534; i1++)
    {
      localRow = localSheet.getRow(i1);
      if (localRow == null)
        continue;
      localCell = localRow.getCell(i);
      if ((localCell == null) || (localCell.getStringCellValue() == null) || (localCell.getStringCellValue().length() <= 0))
        continue;
      localObject2 = new MappingVariable();
      ((MappingVariable)localObject2).setValueName(localCell.getStringCellValue());
      if ((localRow.getCell(j) != null) && (localRow.getCell(j).getStringCellValue() != null) && (localRow.getCell(j).getStringCellValue().length() > 0))
        ((MappingVariable)localObject2).setValueType(localRow.getCell(j).getStringCellValue());
      else
        ((MappingVariable)localObject2).setValueType("string");
      if ((localRow.getCell(k) != null) && (localRow.getCell(k).getStringCellValue() != null) && (localRow.getCell(k).getStringCellValue().length() > 0))
        ((MappingVariable)localObject2).setDisplayName(localRow.getCell(k).getStringCellValue());
      else
        ((MappingVariable)localObject2).setDisplayName(localCell.getStringCellValue());
      if ((localRow.getCell(m) != null) && (localRow.getCell(m).getStringCellValue() != null) && (localRow.getCell(m).getStringCellValue().length() > 0))
        str = localRow.getCell(m).getStringCellValue();
      ((MappingVariable)localObject2).setGroupName(str);
      if ((localRow.getCell(n) != null) && (localRow.getCell(n).getStringCellValue() != null) && (localRow.getCell(n).getStringCellValue().length() > 0))
        ((MappingVariable)localObject2).setValueName(localRow.getCell(n).getStringCellValue() + localCell.getStringCellValue());
      localArrayList.add(localObject2);
    }
    ValueLibrary localValueLibrary = getValueLibrary();
    for (int i2 = 0; i2 < localArrayList.size(); i2++)
    {
      localObject2 = (MappingVariable)localArrayList.get(i2);
      MappingVariable localMappingVariable = localValueLibrary.getVariable(((MappingVariable)localObject2).getValueName());
      if (localMappingVariable != null)
      {
        localMappingVariable.setValueType(((MappingVariable)localObject2).getValueType());
        localMappingVariable.setDisplayName(((MappingVariable)localObject2).getDisplayName());
        localMappingVariable.setGroupName(((MappingVariable)localObject2).getGroupName());
      }
      else
      {
        localValueLibrary.addChildElement((IElement)localObject2);
      }
    }
    setModified(true);
    updateViewer();
  }

  public long getMaxModifyTime()
  {
    return getModifyTime();
  }

  public void registBusinessObject(IBusinessObject paramIBusinessObject)
  {
    if (paramIBusinessObject != null)
    {
      getUuidMap().put(paramIBusinessObject.getUuid(), paramIBusinessObject);
      getUniqueMap().put(paramIBusinessObject.getUniqueName(), paramIBusinessObject);
      if (this.disNameMap != null)
        this.disNameMap.put(paramIBusinessObject.getShowDisplayName(), paramIBusinessObject);
    }
  }

  public void unregistBusinessObject(IBusinessObject paramIBusinessObject)
  {
    if (paramIBusinessObject != null)
    {
      getUuidMap().remove(paramIBusinessObject.getUuid());
      getUniqueMap().remove(paramIBusinessObject.getUniqueName());
      if (this.disNameMap != null)
        this.disNameMap.remove(paramIBusinessObject.getDisplayName());
    }
  }

  public void reRegistAllBusinessObject()
  {
    getUuidMap().clear();
    getUniqueMap().clear();
    if (this.disNameMap != null)
      this.disNameMap.clear();
    Iterator localIterator = getAcceptElements(new aa(this));
    while (localIterator.hasNext())
      registBusinessObject((IBusinessObject)localIterator.next());
  }

  public void addChildElement(IElement paramIElement, int paramInt)
  {
    super.addChildElement(paramIElement, paramInt);
    if (((paramIElement instanceof IBusinessObject)) || ((paramIElement instanceof IBusinessObjectContainer)))
    {
      Iterator localIterator = paramIElement.getAcceptElements(new ab(this));
      while (localIterator.hasNext())
        registBusinessObject((IBusinessObject)localIterator.next());
      if ((paramIElement instanceof IBusinessObject))
        registBusinessObject((IBusinessObject)paramIElement);
    }
  }

  public void clearAllChildren()
  {
    getUuidMap().clear();
    getUniqueMap().clear();
    if (this.disNameMap != null)
      this.disNameMap.clear();
    super.clearAllChildren();
  }

  public void removeChildElement(IElement paramIElement)
  {
    if (((paramIElement instanceof IBusinessObject)) || ((paramIElement instanceof IBusinessObjectContainer)))
    {
      Iterator localIterator = paramIElement.getAcceptElements(new ac(this));
      while (localIterator.hasNext())
        unregistBusinessObject((IBusinessObject)localIterator.next());
      if ((paramIElement instanceof IBusinessObject))
        unregistBusinessObject((IBusinessObject)paramIElement);
    }
    super.removeChildElement(paramIElement);
  }

  public void removeElement(int paramInt)
  {
    IElement localIElement = getElement(paramInt);
    if (((localIElement instanceof IBusinessObject)) || ((localIElement instanceof IBusinessObjectContainer)))
    {
      Iterator localIterator = localIElement.getAcceptElements(new ad(this));
      while (localIterator.hasNext())
        unregistBusinessObject((IBusinessObject)localIterator.next());
      if ((localIElement instanceof IBusinessObject))
        unregistBusinessObject((IBusinessObject)localIElement);
    }
    super.removeElement(paramInt);
  }

  public void dispose()
  {
    getUuidMap().clear();
    getUniqueMap().clear();
    if (this.disNameMap != null)
      this.disNameMap.clear();
    super.dispose();
  }

  public HashMap getUuidMap()
  {
    if (this.uuidMap == null)
      this.uuidMap = new HashMap();
    return this.uuidMap;
  }

  public HashMap getUniqueMap()
  {
    if (this.uniqueMap == null)
      this.uniqueMap = new HashMap();
    return this.uniqueMap;
  }

  public String getDisplayName()
  {
    if ((getParent() instanceof RuleProject))
      return COMMONNAME;
    return DISPLAYNAME;
  }

  public void save()
  {
    if (getProject() != null)
      getProject().save(this, false);
    else
      selfSave();
  }

  public void selfSave()
  {
    IRuleProject localIRuleProject = getProject();
    new File(getFilePathName()).getParentFile().mkdirs();
    e.a(this, new File(getFilePathName()));
    setModified(false);
  }

  public String getFilePathName()
  {
    return this.filePathName;
  }

  public void setFilePathName(String paramString)
  {
    this.filePathName = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.Envionment
 * JD-Core Version:    0.6.0
 */