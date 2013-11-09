package com.flagleader.repository.tree;

import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.Property;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.d.u;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.flow.RulePoolValue;
import com.flagleader.repository.rlm.AbstractElementToken;
import com.flagleader.repository.rlm.value.SheetFentanMapping;
import com.flagleader.repository.rlm.value.SheetFieldMapping;
import com.flagleader.repository.rlm.value.SheetFieldSelectToken;
import com.flagleader.repository.rlm.value.SheetFieldsSelectToken;
import com.flagleader.repository.rlm.value.SheetFunction;
import com.flagleader.repository.rlm.value.SheetWhere;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.SystemUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

public abstract class AbstractRuleTree extends AbstractPackageElement
  implements IRuleTree
{
  private int logtype = 0;
  private boolean actived = true;
  private long createTime = System.currentTimeMillis();
  private long startTime = 0L;
  private long endTime = 0L;
  private boolean sheetWhile = false;
  private String sheetUuid = "";
  private String sheetName = "";
  private int sheetOther = 0;
  private int dataShap = 0;
  private transient boolean runBreak = false;
  private int restartType = 0;
  public static final int UNRESTART = 0;
  public static final int RESTART = 1;
  public static final int NOMATCHRUN = 2;
  public static final int BREAKRUN = 3;
  private int matchType = 1;
  public static final int ALLCONTINUE = 0;
  public static final int ONLYONECONTINUE = 1;
  private int vmlFlowType = 0;
  public static final int SHOWALLRULE = 0;
  public static final int SHOWNAMEONLY = 1;
  public static final int SHOWDETAILONLY = 2;
  public static final int SHOWNAMEDETAIL = 3;
  public static final int SHOWNO = 4;
  private boolean syn = false;
  private transient RulePackage mainPackage = null;
  private transient boolean supportVisit = false;
  protected long a = 0L;
  private String text = "";

  public AbstractRuleTree(AbstractRuleTree paramAbstractRuleTree)
  {
    super(paramAbstractRuleTree);
    this.actived = paramAbstractRuleTree.actived;
    this.logtype = paramAbstractRuleTree.logtype;
    this.startTime = paramAbstractRuleTree.startTime;
    this.endTime = paramAbstractRuleTree.endTime;
    this.sheetWhile = paramAbstractRuleTree.sheetWhile;
    this.sheetUuid = paramAbstractRuleTree.sheetUuid;
    this.sheetName = paramAbstractRuleTree.getSheetName();
    this.sheetOther = paramAbstractRuleTree.sheetOther;
    this.dataShap = paramAbstractRuleTree.dataShap;
    this.restartType = paramAbstractRuleTree.restartType;
    this.matchType = paramAbstractRuleTree.matchType;
  }

  public AbstractRuleTree()
  {
  }

  public AbstractRuleTree(String paramString)
  {
    super(paramString);
  }

  public String getLastModifyTime()
  {
    if (this.f > 0L)
      return new SimpleDateFormat(u.c()).format(new Date(this.f));
    return "";
  }

  public void setLastModifyTime(String paramString)
  {
    try
    {
      this.f = new SimpleDateFormat(u.c()).parse(paramString).getTime();
    }
    catch (ParseException localParseException)
    {
      this.f = 0L;
    }
  }

  public List getAllParent()
  {
    ArrayList localArrayList = new ArrayList(5);
    for (IElement localIElement = getParent(); (localIElement != null) && ((localIElement instanceof IRuleSet)); localIElement = localIElement.getParent())
      localArrayList.add(localIElement);
    return localArrayList;
  }

  public int getPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)) && (getParent().getElementPos(this) >= 0))
      return getParent().getElementPos(this);
    return 0;
  }

  public int getMaxPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)))
      return ((IRuleSet)getParent()).getRuleAndSetCount();
    return 0;
  }

  public void setPos(int paramInt)
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)))
    {
      if (paramInt < 0)
        return;
      int i = getParent().getElementPos(this);
      if (i == paramInt)
        return;
      getParent().removeChildElement(this);
      getParent().addChildElement(this, paramInt);
    }
  }

  public void dispose()
  {
    if ((getParent() instanceof RuleSetFlow))
      ((RuleSetFlow)getParent()).removeFlowElements(getUuid());
    else if ((getParent() instanceof RuleTreeFlow))
      ((RuleTreeFlow)getParent()).removeFlowElements(getUuid());
    else if ((getParent() instanceof RulePoolFlow))
      ((RulePoolFlow)getParent()).removeFlowElements(getUuid());
    super.dispose();
  }

  public int getMinPos()
  {
    return 0;
  }

  public boolean isActived()
  {
    return this.actived;
  }

  public void setActived(boolean paramBoolean)
  {
    this.actived = paramBoolean;
  }

  public long getCreateTime()
  {
    return this.createTime;
  }

  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }

  public List getRelateVarNames()
  {
    HashMap localHashMap = new HashMap();
    getRelateObjectMap(localHashMap);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(localHashMap.keySet());
    localHashMap.clear();
    return localArrayList;
  }

  public String getText()
  {
    if (this.a == getReloadTime())
      return this.text;
    this.text = d();
    this.a = getReloadTime();
    return this.text;
  }

  protected abstract String d();

  public List getAssignVarNames()
  {
    HashMap localHashMap = new HashMap();
    getAssignObjectMap(localHashMap, false);
    ArrayList localArrayList = new ArrayList(localHashMap.size());
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
      localArrayList.add(localIterator.next());
    localHashMap.clear();
    return localArrayList;
  }

  public boolean isChangeLine(String paramString)
  {
    if ((getMainPackage() != null) && (getMainPackage().getHistory() != null))
    {
      IPackageElement localIPackageElement = getMainPackage().getHistory().findRuleHistory(getUuid(), toString());
      if ((localIPackageElement != null) && (localIPackageElement.getText().indexOf(paramString) < 0))
        return true;
    }
    return false;
  }

  public boolean needLog()
  {
    if (this.logtype == 1)
      return false;
    return (getParent() == null) || (!(getParent() instanceof IRuleTree)) || (!((IRuleTree)getParent()).noChildLog());
  }

  public boolean noChildLog()
  {
    if ((this.logtype == 1) || (this.logtype == 2))
      return true;
    if ((getParent() != null) && ((getParent() instanceof IRuleTree)))
      return ((IRuleTree)getParent()).noChildLog();
    return false;
  }

  public int getLogtype()
  {
    return this.logtype;
  }

  public void setLogtype(int paramInt)
  {
    this.logtype = paramInt;
  }

  public IPackageElement getRuleTree()
  {
    return this;
  }

  public long getEndTime()
  {
    return this.endTime;
  }

  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }

  public long getStartTime()
  {
    return this.startTime;
  }

  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }

  public String getClassName()
  {
    return "J" + getUuid();
  }

  public String getPackageName()
  {
    return "";
  }

  public String getClassPath()
  {
    if (getMainPackage() != null)
      return getMainPackage().getClassPath();
    return "";
  }

  public String getFileName()
  {
    return toString();
  }

  public String getExeRulePackageName()
  {
    if (getPackageName().length() > 0)
      return getPackageName() + "." + getFileName();
    return getFileName();
  }

  public String getVisitExeName()
  {
    if (getMainPackage() != null)
      return getMainPackage().getExeRulePackageName() + getVisitRuleName();
    if (getEnvionment() != null)
      return getEnvionment().getDisplayName() + "." + getVisitRuleName();
    return getExeRulePackageName();
  }

  public boolean needRecompile()
  {
    File localFile = new File(getCompilePath(), getFileName() + ".rsc");
    return (!localFile.exists()) || (localFile.lastModified() <= getCompilePackage().getMaxModifyTime());
  }

  public String getCompilePath()
  {
    return SystemUtils.JAVA_IO_TMPDIR;
  }

  public boolean isRunBreak()
  {
    return this.runBreak;
  }

  public void setRunBreak(boolean paramBoolean)
  {
    this.runBreak = paramBoolean;
  }

  public int getSheetOther()
  {
    return this.sheetOther;
  }

  public void setSheetOther(int paramInt)
  {
    this.sheetOther = paramInt;
  }

  public boolean canIncludeSheet()
  {
    return this.sheetOther != 0;
  }

  public boolean isSheetWhile()
  {
    return this.sheetWhile;
  }

  public boolean hasSheetWhile()
  {
    if (((getParent() instanceof IRuleTree)) && (((IRuleTree)getParent()).hasSheetWhile()))
      return true;
    return this.sheetWhile;
  }

  public void setSheetWhile(boolean paramBoolean)
  {
    this.sheetWhile = paramBoolean;
  }

  public String getSheetUuid()
  {
    return this.sheetUuid;
  }

  public void setSheetUuid(String paramString)
  {
    this.sheetUuid = paramString;
  }

  public void setSheetTable(IWhileObject paramIWhileObject)
  {
    this.sheetUuid = paramIWhileObject.getUuid();
    this.sheetName = paramIWhileObject.getUniqueName();
  }

  public boolean isActiveSheetWhile()
  {
    return (isSheetWhile()) && (getWhileSheet() != null);
  }

  public boolean needWhile()
  {
    return (isSheetWhile()) && (f() != null);
  }

  public String getSheetName()
  {
    if ((this.sheetName == null) || (this.sheetName.length() == 0))
    {
      IWhileObject localIWhileObject = getWhileSheet();
      if (localIWhileObject != null)
        this.sheetName = localIWhileObject.getDisplayName();
    }
    return this.sheetName;
  }

  public void setSheetName(String paramString)
  {
    this.sheetName = paramString;
  }

  public List getAllWhileSheets()
  {
    ArrayList localArrayList = new ArrayList();
    IWhileObject localIWhileObject = e();
    if (localIWhileObject != null)
      localArrayList.add(localIWhileObject);
    if ((getParent() instanceof AbstractRuleTree))
      ((AbstractRuleTree)getParent()).a(localArrayList);
    return localArrayList;
  }

  protected IWhileObject e()
  {
    if (isSheetWhile())
      return getWhileSheet();
    return null;
  }

  protected void a(List paramList)
  {
    IWhileObject localIWhileObject = e();
    if (localIWhileObject != null)
    {
      int i = 0;
      for (int j = 0; j < paramList.size(); j++)
      {
        if (!paramList.get(j).equals(localIWhileObject))
          continue;
        i = 1;
        break;
      }
      if (i == 0)
        paramList.add(localIWhileObject);
    }
    if ((getParent() instanceof AbstractRuleTree))
      ((AbstractRuleTree)getParent()).a(paramList);
  }

  protected boolean a(IWhileObject paramIWhileObject)
  {
    if ((isSheetWhile()) && (paramIWhileObject.equals(getWhileSheet())))
      return true;
    if ((getParent() instanceof AbstractRuleTree))
      return ((AbstractRuleTree)getParent()).a(paramIWhileObject);
    return false;
  }

  protected IWhileObject f()
  {
    IWhileObject localIWhileObject = e();
    if (localIWhileObject == null)
      return null;
    if ((!(getParent() instanceof AbstractRuleTree)) || (!((AbstractRuleTree)getParent()).a(localIWhileObject)))
      return localIWhileObject;
    return null;
  }

  public IWhileObject getWhileSheet()
  {
    if (((this.sheetUuid.length() > 0) || (this.sheetName.length() > 0)) && (getEnvionment() != null))
    {
      Iterator localIterator = getRuleTree().getEnvionment().getAcceptElements(new f(this));
      IWhileObject localIWhileObject;
      if (localIterator.hasNext())
      {
        localIWhileObject = (IWhileObject)localIterator.next();
        if ((localIWhileObject != null) && ((!localIWhileObject.getUuid().equals(this.sheetUuid)) || (!localIWhileObject.getUniqueName().equals(this.sheetName))))
        {
          setSheetTable(localIWhileObject);
          setNeedSave();
        }
        return localIWhileObject;
      }
      localIterator = getRuleTree().getEnvionment().getAcceptElements(new g(this));
      if (localIterator.hasNext())
      {
        localIWhileObject = (IWhileObject)localIterator.next();
        if ((localIWhileObject != null) && ((!localIWhileObject.getUuid().equals(this.sheetUuid)) || (!localIWhileObject.getUniqueName().equals(this.sheetName))))
        {
          setSheetTable(localIWhileObject);
          setNeedSave();
        }
        return localIWhileObject;
      }
    }
    return null;
  }

  public IBusinessObject getBusinessObject(String paramString)
  {
    return getEnvionment().getBusinessObject(paramString, getAllWhileSheets());
  }

  public int getDataShap()
  {
    return this.dataShap;
  }

  public void setDataShap(int paramInt)
  {
    this.dataShap = paramInt;
  }

  public boolean isEnableDataSnap()
  {
    return this.dataShap != 0;
  }

  public int getRestartType()
  {
    return this.restartType;
  }

  public void setRestartType(int paramInt)
  {
    this.restartType = paramInt;
  }

  public int getMatchType()
  {
    return this.matchType;
  }

  public void setMatchType(int paramInt)
  {
    this.matchType = paramInt;
  }

  public int getVmlFlowType()
  {
    return this.vmlFlowType;
  }

  public void setVmlFlowType(int paramInt)
  {
    this.vmlFlowType = paramInt;
  }

  protected CellStyle a(Workbook paramWorkbook)
  {
    Font localFont = paramWorkbook.createFont();
    localFont.setFontName(MessageUtil.getString("excelDefaultFontName"));
    localFont.setFontHeightInPoints(12);
    localFont.setColor(IndexedColors.RED.getIndex());
    CellStyle localCellStyle = paramWorkbook.createCellStyle();
    localCellStyle.setBorderBottom(1);
    localCellStyle.setBorderLeft(1);
    localCellStyle.setBorderRight(1);
    localCellStyle.setBorderTop(1);
    localCellStyle.setFont(localFont);
    localCellStyle.setWrapText(true);
    return localCellStyle;
  }

  protected void a(Cell paramCell, String paramString, CellStyle paramCellStyle, FormulaEvaluator paramFormulaEvaluator)
  {
    if (!paramString.equals(a(paramCell, paramFormulaEvaluator)))
      paramCell.setCellStyle(paramCellStyle);
  }

  protected String a(Cell paramCell, FormulaEvaluator paramFormulaEvaluator)
  {
    if (paramCell != null)
      switch (paramCell.getCellType())
      {
      case 4:
        return StringUtil.stringValue(paramCell.getBooleanCellValue());
      case 0:
        if (DateUtil.isCellDateFormatted(paramCell))
          return Property.getInstance().formatDate(paramCell.getDateCellValue());
        return StringUtil.stringValue(paramCell.getNumericCellValue());
      case 1:
        return paramCell.getStringCellValue();
      case 3:
        break;
      case 5:
        break;
      case 2:
        try
        {
          CellValue localCellValue = paramFormulaEvaluator.evaluate(paramCell);
          switch (localCellValue.getCellType())
          {
          case 4:
            return StringUtil.stringValue(localCellValue.getBooleanValue());
          case 0:
            return StringUtil.stringValue(localCellValue.getNumberValue());
          case 1:
            return localCellValue.getStringValue();
          case 3:
            break;
          case 5:
          case 2:
          }
        }
        catch (Exception localException)
        {
        }
      }
    return "";
  }

  public String parseShortRuleName(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1))
      return paramString1;
    if (paramString1.trim().startsWith(paramString2))
    {
      String str = paramString1.trim().substring(paramString2.length()).trim();
      str = StringUtil.replace(u.a("notNary.edit") + " " + paramString2, u.a("notNary.edit"), str);
      str = StringUtil.replace(u.a("isNary.edit") + " " + paramString2, u.a("notNary.edit"), str);
      str = StringUtil.replace(u.a("notNary.edit") + paramString2, u.a("notNary.edit"), str);
      str = StringUtil.replace(u.a("isNary.edit") + paramString2, u.a("notNary.edit"), str);
      return str;
    }
    return paramString1.trim();
  }

  public String parseShortName(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1))
      return paramString1;
    if (paramString1.trim().startsWith(paramString2))
    {
      String str = StringUtil.replace(paramString2 + u.a("EqualsTo.edit", "equals to "), "", paramString1.trim()).trim();
      str = StringUtil.replace(u.a("notNary.edit") + " " + paramString2, u.a("notNary.edit"), str);
      str = StringUtil.replace(u.a("isNary.edit") + " " + paramString2, u.a("notNary.edit"), str);
      str = StringUtil.replace(u.a("notNary.edit") + paramString2, u.a("notNary.edit"), str);
      str = StringUtil.replace(u.a("isNary.edit") + paramString2, u.a("notNary.edit"), str);
      if (str.startsWith(paramString2))
        return str.substring(paramString2.length());
      return str;
    }
    return paramString1.trim();
  }

  protected boolean a(Map paramMap, IElement paramIElement)
  {
    int i = 0;
    Object localObject2;
    if ((paramIElement instanceof AbstractElementToken))
    {
      localObject1 = ((AbstractElementToken)paramIElement).getMemberElement();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IElement)))
        {
          ((AbstractElementToken)paramIElement).setMemberElement((IElement)localObject2);
          i = 1;
        }
      }
    }
    else if ((paramIElement instanceof DecisionElement))
    {
      localObject1 = ((DecisionElement)paramIElement).getMemberElement();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IBusinessObject)))
        {
          ((DecisionElement)paramIElement).setMemberElement((IBusinessObject)localObject2);
          i = 1;
        }
      }
    }
    else if ((paramIElement instanceof DecisionElementValue))
    {
      localObject1 = ((DecisionElementValue)paramIElement).getMemberElement();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IBusinessObject)))
        {
          ((DecisionElementValue)paramIElement).setElementUuid(((IBusinessObject)localObject2).getUuid());
          ((DecisionElementValue)paramIElement).setUniqueName(((IBusinessObject)localObject2).getUniqueName());
          i = 1;
        }
      }
    }
    else if ((paramIElement instanceof SheetFieldMapping))
    {
      localObject1 = ((SheetFieldMapping)paramIElement).getMemberElement();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IBusinessObject)))
        {
          ((SheetFieldMapping)paramIElement).setField((IBusinessObject)localObject2);
          i = 1;
        }
      }
      localObject1 = ((SheetFieldMapping)paramIElement).getMappingField();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IBusinessObject)))
        {
          ((SheetFieldMapping)paramIElement).setMappingField((IBusinessObject)localObject2);
          i = 1;
        }
      }
    }
    else if ((paramIElement instanceof SheetFentanMapping))
    {
      localObject1 = ((SheetFentanMapping)paramIElement).getMemberElement();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IBusinessObject)))
        {
          ((SheetFentanMapping)paramIElement).setField((IBusinessObject)localObject2);
          i = 1;
        }
      }
      localObject1 = ((SheetFentanMapping)paramIElement).getMappingField();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IBusinessObject)))
        {
          ((SheetFentanMapping)paramIElement).setMappingField((IBusinessObject)localObject2);
          i = 1;
        }
      }
      localObject1 = ((SheetFentanMapping)paramIElement).getBField();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IBusinessObject)))
        {
          ((SheetFentanMapping)paramIElement).setBField((IBusinessObject)localObject2);
          i = 1;
        }
      }
    }
    else if ((paramIElement instanceof SheetFieldSelectToken))
    {
      localObject1 = ((SheetFieldSelectToken)paramIElement).getSelected();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IBusinessObject)))
        {
          ((SheetFieldSelectToken)paramIElement).setSelected((IBusinessObject)localObject2);
          i = 1;
        }
      }
    }
    else if ((paramIElement instanceof RulePoolValue))
    {
      localObject1 = ((RulePoolValue)paramIElement).getSelected();
      if ((localObject1 != null) && (paramMap.get(localObject1) != null))
      {
        localObject2 = paramMap.get(localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof IBusinessObject)))
        {
          ((RulePoolValue)paramIElement).setSelected((IBusinessObject)localObject2);
          i = 1;
        }
      }
    }
    else if ((paramIElement instanceof SheetFieldsSelectToken))
    {
      localObject1 = ((SheetFieldsSelectToken)paramIElement).getSelectedElements();
      for (int j = 0; j < ((List)localObject1).size(); j++)
      {
        IBusinessObject localIBusinessObject = (IBusinessObject)((List)localObject1).get(j);
        if ((localIBusinessObject == null) || (paramMap.get(localIBusinessObject) == null))
          continue;
        Object localObject4 = paramMap.get(localIBusinessObject);
        if ((localObject4 == null) || (!(localObject4 instanceof IBusinessObject)))
          continue;
        ((List)localObject1).remove(j);
        ((List)localObject1).add(j, (IBusinessObject)localObject4);
        i = 1;
      }
      if (i != 0)
        ((SheetFieldsSelectToken)paramIElement).setSelected((List)localObject1);
    }
    else
    {
      Object localObject3;
      if ((paramIElement instanceof SheetFunction))
      {
        localObject1 = ((SheetFunction)paramIElement).getField();
        if ((localObject1 != null) && (paramMap.get(localObject1) != null))
        {
          localObject3 = paramMap.get(localObject1);
          if ((localObject3 != null) && ((localObject3 instanceof IBusinessObject)))
          {
            ((SheetFunction)paramIElement).setFieldUuid(((IBusinessObject)localObject3).getUuid());
            ((SheetFunction)paramIElement).setFieldUnique(((IBusinessObject)localObject3).getUniqueName());
            i = 1;
          }
        }
      }
      else if ((paramIElement instanceof SheetWhere))
      {
        localObject1 = ((SheetWhere)paramIElement).getField();
        if ((localObject1 != null) && (paramMap.get(localObject1) != null))
        {
          localObject3 = paramMap.get(localObject1);
          if ((localObject3 != null) && ((localObject3 instanceof IBusinessObject)))
          {
            ((SheetWhere)paramIElement).setFieldUuid(((IBusinessObject)localObject3).getUuid());
            ((SheetWhere)paramIElement).setFieldUnique(((IBusinessObject)localObject3).getUniqueName());
            i = 1;
          }
        }
      }
    }
    Object localObject1 = paramIElement.getChildrenList().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      if (!a(paramMap, (IElement)((Iterator)localObject1).next()))
        continue;
      i = 1;
    }
    return i;
  }

  public boolean replaceVariable(Map paramMap)
  {
    if (a(paramMap, this))
    {
      setModified(true);
      return true;
    }
    return false;
  }

  public boolean isSyn()
  {
    return this.syn;
  }

  public void setSyn(boolean paramBoolean)
  {
    this.syn = paramBoolean;
  }

  public IRulePackage getCompilePackage()
  {
    IRulePackage localIRulePackage = getMainPackage();
    if ((localIRulePackage == null) && (getEnvionment() != null))
    {
      if (this.mainPackage == null)
      {
        this.mainPackage = new RulePackage();
        this.mainPackage.appendChild(this);
        this.mainPackage.appendChild(getEnvionment());
      }
      this.mainPackage.setPackageName(getParent().getDisplayName());
      this.mainPackage.setFileName(getDisplayName());
      this.mainPackage.setDisplayName(getParent().getDisplayName() + "." + getDisplayName());
      return this.mainPackage;
    }
    return localIRulePackage;
  }

  public String getVisitRuleName()
  {
    if ((getParent() instanceof IRuleTree))
      return ((IRuleTree)getParent()).getVisitRuleName() + "@" + getDisplayName();
    return "@" + getDisplayName();
  }

  public boolean paste(IElement paramIElement)
  {
    if ((paramIElement instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        IElement localIElement = (IElement)localIterator.next();
        if ((localIElement instanceof IRuleTree))
          continue;
        getEnvionment().paste(localIElement);
      }
    }
    return super.paste(paramIElement);
  }

  public boolean supportVisitRule()
  {
    if (this.supportVisit)
      return true;
    return getParent() instanceof RulePackage;
  }

  public boolean isSupportVisit()
  {
    return this.supportVisit;
  }

  public void setSupportVisit(boolean paramBoolean)
  {
    this.supportVisit = paramBoolean;
  }

  public String getWebPosString()
  {
    if (!(getParent() instanceof IRuleTree))
      return String.valueOf(getPos() + 1);
    return ((IRuleTree)getParent()).getWebPosString() + "." + (getPos() + 1);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.AbstractRuleTree
 * JD-Core Version:    0.6.0
 */