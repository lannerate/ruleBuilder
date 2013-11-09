package com.flagleader.builder.a.f;

import com.flagleader.a.A;
import com.flagleader.a.B;
import com.flagleader.a.ak;
import com.flagleader.a.y;
import com.flagleader.a.z;
import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bs;
import com.flagleader.builder.a.bu;
import com.flagleader.engine.IRuleLog;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.manager.e.U;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.BusinessObjectMember;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.StringUtil;
import com.flagleader.xml.Node;
import java.beans.PropertyDescriptor;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class do extends aS
  implements bs, IElementViewer
{
  private Table f;
  private TableItem g;
  private TableEditor q;
  private HashMap r = new HashMap();
  private U s;
  private HashMap t;
  private IRuleLog u;
  int e = 0;

  public do(IRuleClass paramIRuleClass, Composite paramComposite, bu parambu)
  {
    super(paramIRuleClass, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new do((IRuleClass)this.c, paramComposite, this.a);
  }

  protected IRuleClass e()
  {
    return (IRuleClass)this.c;
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.f = new Table(localComposite, 65536);
    GridData localGridData = new GridData();
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    this.f.setLayoutData(localGridData);
    this.f.setHeaderVisible(true);
    this.f.setLinesVisible(true);
    f();
    this.f.setVisible(true);
    this.f.addMouseListener(new du(this));
    return localComposite;
  }

  protected void h()
  {
    a(new ds(this));
    a(new dt(this));
    a(new dx(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "go");
    a(paramToolBar, "gointer");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "RecordTrace");
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.f.removeAll();
    Control[] arrayOfControl = this.f.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    List localList = e().getPropertiesList();
    for (int j = 0; (localList != null) && (j < localList.size()); j++)
    {
      AdvancedProperty localAdvancedProperty = (AdvancedProperty)localList.get(j);
      this.r.put(localAdvancedProperty.getKey(), localAdvancedProperty.getProperty());
    }
    g();
    super.update();
    z();
  }

  public boolean needUpdate()
  {
    return this.d == 0L;
  }

  private void f()
  {
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("displayName.test"));
    localTableColumn.setWidth(80);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("Type.test"));
    localTableColumn.setWidth(80);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("InitialValue.test"));
    localTableColumn.setWidth(110);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("ResultValue.test"));
    localTableColumn.setWidth(110);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("AttributeName.Test"));
    localTableColumn.setWidth(80);
  }

  private void g()
  {
    Iterator localIterator = e().getEnvionment().getAllTestVariable();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      Object localObject2;
      Object localObject3;
      if ((localObject1 instanceof BusinessObjectAttribute))
      {
        localObject2 = new TableItem(this.f, 8);
        localObject3 = (BusinessObjectAttribute)localObject1;
        a((TableItem)localObject2, ((BusinessObjectAttribute)localObject3).getDisplayName(), ((BusinessObjectAttribute)localObject3).getValueType(), ((BusinessObjectAttribute)localObject3).getValueName());
      }
      else if ((localObject1 instanceof MappingVariable))
      {
        localObject2 = new TableItem(this.f, 8);
        localObject3 = (MappingVariable)localObject1;
        a((TableItem)localObject2, ((MappingVariable)localObject3).getDisplayName(), ((MappingVariable)localObject3).getValueType(), ((MappingVariable)localObject3).getValueName());
      }
      else if (((localObject1 instanceof BusinessObjectClass)) && (!(localObject1 instanceof FunctionClass)))
      {
        localObject2 = ((BusinessObjectClass)localObject1).getClazz();
        if (localObject2 == null)
          continue;
        localObject3 = ((B)localObject2).m().a();
        String str1 = ((B)localObject2).K();
        while (((z)localObject3).hasNext())
        {
          y localy = (y)((z)localObject3).next();
          int i = a((B)localObject2, localy);
          if (i <= 0)
            continue;
          TableItem localTableItem = new TableItem(this.f, 8);
          String str2 = localy.N();
          String str3 = localy.e().K();
          if (i == 1)
            a(localTableItem, ((BusinessObjectClass)localObject1).getMemberToken(localy.I()).getDisplayName(), str3, str1 + "." + str2);
          else
            a(localTableItem, localy.I(), str3, str1 + "." + str2);
        }
      }
      else if ((localObject1 instanceof XmlNode))
      {
        localObject2 = new TableItem(this.f, 8);
        localObject3 = (XmlNode)localObject1;
        a((TableItem)localObject2, ((XmlNode)localObject3).getDisplayName(), ((XmlNode)localObject3).getValueType(), ((XmlNode)localObject3).getValueName());
      }
      else if ((localObject1 instanceof TreeValueNode))
      {
        localObject2 = new TableItem(this.f, 8);
        localObject3 = (TreeValueNode)localObject1;
        a((TableItem)localObject2, ((TreeValueNode)localObject3).getDisplayName(), ((TreeValueNode)localObject3).getValueType(), ((TreeValueNode)localObject3).getValueName());
      }
      else
      {
        if (!(localObject1 instanceof SheetTable))
          continue;
        localObject2 = new TableItem(this.f, 8);
        localObject3 = (SheetTable)localObject1;
        a((TableItem)localObject2, ((SheetTable)localObject3).getDisplayName(), ((SheetTable)localObject3).getValueType(), ((SheetTable)localObject3).getValueName());
      }
    }
    Object localObject1 = new TableItem(this.f, 8);
    a((TableItem)localObject1, ResourceTools.getMessage("ruleLog.Test"), "com.flagleader.rules.RuleLog", "ruleLog");
    localObject1 = new TableItem(this.f, 8);
    a((TableItem)localObject1, ResourceTools.getMessage("shapShot.Test"), "List<String[]>", "snapShot");
  }

  private Class c(String paramString)
  {
    String str = "";
    if (e().getCompilePackage() != null)
      str = e().getCompilePackage().getUuid();
    return RuleEngineFactory.getInstance(str).getClassLoader().loadClass(paramString);
  }

  public void a_()
  {
    this.e = 0;
    this.s = ((U)a().getRulesManager().l().a(e(), this.r, ""));
    z();
    a(this.s.q(), false, true);
    C();
    a().getShell().setCursor(a().getShell().getDisplay().getSystemCursor(3));
    dp localdp = new dp(this);
    Display.getCurrent().timerExec(100, localdp);
  }

  public void a(String paramString)
  {
    this.e = 0;
    e().setSupportVisit(true);
    if (StringUtil.isEmpty(paramString))
      this.s = ((U)a().getRulesManager().l().a(e(), this.r, ""));
    else
      this.s = ((U)a().getRulesManager().l().a(e().getCompilePackage(), this.r, paramString));
    z();
    a(this.s.q(), false, true);
    C();
    a().getShell().setCursor(a().getShell().getDisplay().getSystemCursor(3));
    dq localdq = new dq(this);
    Display.getCurrent().timerExec(100, localdq);
  }

  public void a(HashMap paramHashMap, List paramList, IRuleLog paramIRuleLog)
  {
    this.t = paramHashMap;
    this.u = paramIRuleLog;
    this.p = this.e;
    e().setSupportVisit(false);
    b(this.p);
    z();
    this.f.getDisplay().asyncExec(new dr(this, paramList, paramIRuleLog));
  }

  private void a(TableItem paramTableItem, String paramString1, String paramString2, String paramString3)
  {
    paramTableItem.setText(0, paramString1);
    paramTableItem.setText(1, paramString2);
    paramTableItem.setText(4, paramString3);
    if (this.r.get(paramString3) != null)
      paramTableItem.setText(2, this.r.get(paramString3).toString());
  }

  public String a(Object paramObject)
  {
    if (paramObject == null)
      return "";
    try
    {
      if ((paramObject instanceof String))
        return (String)paramObject;
      if ((paramObject instanceof byte[]))
        return new String((byte[])paramObject);
      if ((paramObject instanceof Blob))
        return new String(((Blob)paramObject).getBytes(1L, (int)((Blob)paramObject).length()));
      if ((paramObject instanceof Clob))
        return ((Clob)paramObject).getSubString(1L, (int)((Clob)paramObject).length());
      if ((paramObject instanceof java.sql.Date))
        return Property.getInstance().formatDate((java.sql.Date)paramObject);
      if ((paramObject instanceof Time))
        return Property.getInstance().formatTime((Time)paramObject);
      if (((paramObject instanceof Timestamp)) || ((paramObject instanceof java.util.Date)))
        return Property.getInstance().formatDatetime((java.util.Date)paramObject);
      if ((paramObject instanceof Node))
        return ((Node)paramObject).getContent();
    }
    catch (SQLException localSQLException)
    {
      return "";
    }
    return StringUtil.stringValue(paramObject);
  }

  private int a(B paramB, y paramy)
  {
    if (paramy.l())
      return 1;
    if ((paramy.j()) || (paramy.k()))
      try
      {
        PropertyDescriptor localPropertyDescriptor = PropertyUtils.getPropertyDescriptor(paramB.V().newInstance(), paramy.N());
        if ((PropertyUtils.getReadMethod(localPropertyDescriptor) != null) && (PropertyUtils.getWriteMethod(localPropertyDescriptor) != null))
          return 2;
      }
      catch (Exception localException)
      {
        return 0;
      }
    return 0;
  }

  public String getCompositeUuid()
  {
    return this.c.getEditUuid() + "test";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.do
 * JD-Core Version:    0.6.0
 */