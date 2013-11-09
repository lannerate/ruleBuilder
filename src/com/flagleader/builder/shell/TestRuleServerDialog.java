package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.g;
import com.flagleader.engine.IRuleContext;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleService;
import com.flagleader.engine.impl.RuleServerPoolFactory;
import com.flagleader.repository.d.w;
import com.flagleader.repository.e.d;
import com.flagleader.repository.lang.b;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class TestRuleServerDialog extends g
{
  private static final int g = 380;
  private static final int h = 200;
  private Table i;
  private List j;
  private HashMap k = new HashMap();
  private boolean l = false;
  private TableEditor m;
  private TableItem n;
  private Text o;
  private Text p;
  private Text q;
  private Combo r;
  private String s;
  String a = "1508";
  String b = "localhost";
  private long t = 1000L;
  private int u = 0;
  private int v = 0;
  private int w;
  Label c;
  Label d;
  Label e;
  public static String[] f = com.flagleader.manager.d.c.d("securityTypes.TestRuleServerDialog");

  static
  {
    for (int i1 = 0; i1 < f.length; i1++)
      f[i1] = com.flagleader.manager.d.c.b(f[i1] + ".TestRuleServerDialog");
  }

  public TestRuleServerDialog(Shell paramShell)
  {
    super(paramShell);
    this.s = "";
    this.b = "localhost";
    this.a = "1508";
    this.j = new ArrayList(0);
  }

  public TestRuleServerDialog(Shell paramShell, IRuleContext paramIRuleContext, String paramString)
  {
    super(paramShell);
    this.s = paramString;
    this.b = "localhost";
    this.a = "1508";
    this.j = new ArrayList(0);
    a(paramIRuleContext);
  }

  public TestRuleServerDialog(Shell paramShell, IRulePackage paramIRulePackage)
  {
    super(paramShell);
    this.s = paramIRulePackage.getExeRulePackageName();
    this.b = "localhost";
    this.a = "1508";
    this.j = new ArrayList(0);
    a(paramIRulePackage);
  }

  public void a(IRulePackage paramIRulePackage)
  {
    Iterator localIterator = paramIRulePackage.getEnvionment().getInVariables();
    while (localIterator.hasNext())
    {
      localObject = (IBusinessObjectEditen)localIterator.next();
      if (!(localObject instanceof MappingVariable))
        continue;
      this.j.add(new AdvancedProperty(((IBusinessObjectEditen)localObject).getValueName(), StringUtil.stringValue(b.a().b().d(((IBusinessObjectEditen)localObject).getValueType()))));
      this.k.put(((IBusinessObjectEditen)localObject).getValueName(), ((IBusinessObjectEditen)localObject).getValueName());
    }
    Object localObject = paramIRulePackage.getEnvionment().getOutVariables();
    while (localIterator.hasNext())
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)localIterator.next();
      if ((this.k.get(localIBusinessObjectEditen.getValueName()) != null) || (!(localIBusinessObjectEditen instanceof MappingVariable)))
        continue;
      this.j.add(new AdvancedProperty(localIBusinessObjectEditen.getValueName(), ""));
    }
  }

  public void a(IRuleContext paramIRuleContext)
  {
    String[] arrayOfString1 = paramIRuleContext.getInputs();
    Map localMap = paramIRuleContext.getValueTypes();
    for (int i1 = 0; (arrayOfString1 != null) && (i1 < arrayOfString1.length); i1++)
    {
      String str1 = "string";
      if ((localMap != null) && (localMap.get(arrayOfString1[i1]) != null))
        str1 = localMap.get(arrayOfString1[i1]).toString();
      this.j.add(new AdvancedProperty(arrayOfString1[i1], StringUtil.stringValue(b.a().b().d(str1))));
      this.k.put(arrayOfString1[i1], arrayOfString1[i1]);
    }
    String[] arrayOfString2 = paramIRuleContext.getOutputs();
    for (int i2 = 0; (arrayOfString2 != null) && (i2 < arrayOfString2.length); i2++)
    {
      if (this.k.get(arrayOfString2[i2]) != null)
        continue;
      String str2 = "string";
      if ((localMap != null) && (localMap.get(arrayOfString2[i2]) != null))
        str2 = localMap.get(arrayOfString2[i2]).toString();
      this.j.add(new AdvancedProperty(arrayOfString2[i2], ""));
    }
  }

  public static void main(String[] paramArrayOfString)
  {
    TestRuleServerDialog localTestRuleServerDialog = new TestRuleServerDialog(new Shell());
    localTestRuleServerDialog.open();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(3));
    Group localGroup = new Group(localComposite1, 16777216);
    localGroup.setLayout(a(2));
    localGroup.setLayoutData(a(400, 70));
    localGroup.setText(com.flagleader.manager.d.c.b("serverinfo.TestRuleServerDialog"));
    this.e = a(localGroup, "serverip.TestRuleServerDialog");
    this.q = b(localGroup, 2048, 300, 12);
    this.d = a(localGroup, "serverport.TestRuleServerDialog");
    this.p = b(localGroup, 2048, 300, 12);
    this.o = a(localComposite2, "exeRuleName.TestRuleServerDialog", 2048, 240, 12, 2);
    this.o.setText(this.s);
    this.o.selectAll();
    Button localButton = g(localComposite2);
    localButton.setText(b("LoadRPK.TestRuleServerDialog"));
    localButton.addSelectionListener(new gc(this));
    localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    this.r = b(localComposite2, "sendtype.TestRuleServerDialog", 2048, 280, 12, 2);
    this.r.setItems(f);
    this.r.setVisibleItemCount(f.length);
    this.r.addSelectionListener(new gg(this));
    this.r.select(this.u);
    this.p.setText(String.valueOf(this.a));
    this.q.setText(String.valueOf(this.b));
    Composite localComposite3 = new Composite(localComposite1, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    d(localComposite3);
    Composite localComposite4 = new Composite(localComposite1, 0);
    localComposite4.setLayoutData(new GridData(1808));
    localComposite4.setLayout(a(5));
    e(localComposite4);
    b(localComposite1);
    return localComposite1;
  }

  private void s()
  {
    String[] arrayOfString1 = { "*.rsc", "*.rpk" };
    FileDialog localFileDialog = new FileDialog(getShell());
    localFileDialog.setFilterExtensions(arrayOfString1);
    if (localFileDialog.open() == null)
      return;
    File localFile = new File(localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName());
    try
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (localFile.getName().endsWith(".rpk"))
      {
        localObject1 = (RulePackage)new d().load(localFile);
        this.o.setText(((RulePackage)localObject1).getExeRulePackageName());
        this.i.removeAll();
        localObject2 = ((RulePackage)localObject1).getEnvionment().getAllMappingVariable();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MappingVariable)((Iterator)localObject2).next();
          if (((MappingVariable)localObject3).getInout() == 2)
            continue;
          TableItem localTableItem1 = new TableItem(this.i, 0);
          localTableItem1.setText(new String[] { ((MappingVariable)localObject3).getValueName(), StringUtil.stringValue(((MappingVariable)localObject3).getTypeManager().d(((MappingVariable)localObject3).getValueType())) });
        }
      }
      else
      {
        localObject1 = new w().a(localFile.toURL());
        this.o.setText(((IRuleContext)localObject1).getRuleName());
        this.i.removeAll();
        localObject2 = ((IRuleContext)localObject1).getInputs();
        localObject3 = ((IRuleContext)localObject1).getValueTypes();
        Object localObject4;
        for (int i1 = 0; (localObject2 != null) && (i1 < localObject2.length); i1++)
        {
          TableItem localTableItem2 = new TableItem(this.i, 0);
          localObject4 = "string";
          if ((localObject3 != null) && (((Map)localObject3).get(localObject2[i1]) != null))
            localObject4 = ((Map)localObject3).get(localObject2[i1]).toString();
          localTableItem2.setText(new String[] { localObject2[i1], StringUtil.stringValue(b.a().b().d((String)localObject4)) });
          this.k.put(localObject2[i1], localObject2[i1]);
        }
        String[] arrayOfString2 = ((IRuleContext)localObject1).getOutputs();
        for (int i2 = 0; (arrayOfString2 != null) && (i2 < arrayOfString2.length); i2++)
        {
          if (this.k.get(arrayOfString2[i2]) != null)
            continue;
          localObject4 = new TableItem(this.i, 0);
          String str = "string";
          if ((localObject3 != null) && (((Map)localObject3).get(arrayOfString2[i2]) != null))
            str = ((Map)localObject3).get(arrayOfString2[i2]).toString();
          ((TableItem)localObject4).setText(new String[] { arrayOfString2[i2], "" });
        }
      }
      this.l = true;
    }
    catch (Exception localException)
    {
      EngineLogger.getSqlLogger().error(localException.getMessage());
    }
  }

  private void d(Composite paramComposite)
  {
    f(paramComposite);
    b(this.i);
    a(this.i);
    this.m = new TableEditor(this.i);
    this.i.addKeyListener(new gh(this));
    this.i.addMouseMoveListener(new gi(this));
    this.i.addMouseListener(new gj(this));
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(this.i.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.n, paramInt);
    paramText.addFocusListener(new gk(this, paramText, paramTableItem, paramInt, paramTableEditor));
    paramText.addTraverseListener(new gl(this, paramText, paramTableItem, paramInt, paramTableEditor));
  }

  private void e(Composite paramComposite)
  {
    Button localButton1 = g(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new gm(this));
    Button localButton2 = g(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new gn(this));
    Button localButton3 = g(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new gd(this));
    localButton1 = g(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new ge(this));
    Button localButton4 = g(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new gf(this));
  }

  private Table f(Composite paramComposite)
  {
    this.i = new Table(paramComposite, 67586);
    GridData localGridData = new GridData();
    localGridData.widthHint = 380;
    localGridData.heightHint = 200;
    this.i.setLayoutData(localGridData);
    this.i.setLinesVisible(true);
    return this.i;
  }

  private void a(Table paramTable)
  {
    if (this.j != null)
      for (int i1 = 0; i1 < this.j.size(); i1++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        AdvancedProperty localAdvancedProperty = (AdvancedProperty)this.j.get(i1);
        localTableItem.setText(new String[] { localAdvancedProperty.getKey(), localAdvancedProperty.getProperty() });
      }
  }

  private void b(Table paramTable)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("valuename.TestRuleServerDialog"));
    localTableColumn.setWidth(120);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("inputvalue.TestRuleServerDialog"));
    localTableColumn.setWidth(120);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("outputvalue.TestRuleServerDialog"));
    localTableColumn.setWidth(120);
  }

  private TableItem t()
  {
    if (this.i.getSelectionIndex() >= 0)
      return this.i.getSelection()[0];
    return null;
  }

  private Button g(Composite paramComposite)
  {
    Button localButton = new Button(paramComposite, 8);
    GridData localGridData = new GridData();
    localGridData.widthHint = 65;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.horizontalIndent = 16;
    localButton.setLayoutData(localGridData);
    return localButton;
  }

  protected void okPressed()
  {
    if (this.o.getText().length() == 0)
      return;
    if (this.j.size() > 0)
      this.j.clear();
    this.s = this.o.getText();
    if (this.p.getText().length() > 0)
      this.a = this.p.getText();
    if (this.q.getText().length() > 0)
      this.b = this.q.getText();
    this.u = this.r.getSelectionIndex();
    try
    {
      RuleServerPoolFactory localRuleServerPoolFactory = RuleServerPoolFactory.getFactory(this.b, Integer.parseInt(this.a));
      Property.getInstance().setServerSendtype(this.u);
      long l1 = System.currentTimeMillis();
      RuleService localRuleService = localRuleServerPoolFactory.getRuleService();
      TableItem[] arrayOfTableItem = this.i.getItems();
      for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
      {
        if ((arrayOfTableItem[i1].getText(0).length() <= 0) || (arrayOfTableItem[i1].getText(1).length() <= 0))
          continue;
        localRuleService.put(arrayOfTableItem[i1].getText(0), arrayOfTableItem[i1].getText(1));
      }
      localRuleService.execute(this.s);
      for (i1 = 0; i1 < arrayOfTableItem.length; i1++)
      {
        if ((arrayOfTableItem[i1].getText(0).length() <= 0) || (localRuleService.get(arrayOfTableItem[i1].getText(0)) == null))
          continue;
        arrayOfTableItem[i1].setText(2, StringUtil.stringValue(localRuleService.get(arrayOfTableItem[i1].getText(0))));
      }
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getMessage());
    }
  }

  protected void a()
  {
    close();
  }

  public boolean b()
  {
    return this.i.getSelectionCount() > 0;
  }

  public boolean c()
  {
    return this.i.getSelectionCount() > 0;
  }

  public boolean d()
  {
    return this.i.getSelectionCount() > 0;
  }

  public boolean e()
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(com.flagleader.builder.widget.c.a());
    if (localObject == null)
      return false;
    if ((localObject instanceof ArrayList))
    {
      ArrayList localArrayList = (ArrayList)localObject;
      for (int i1 = 0; i1 < localArrayList.size(); i1++)
        if ((localArrayList.get(i1) instanceof ArrayList))
          return true;
    }
    return false;
  }

  public void f()
  {
    TableItem[] arrayOfTableItem = this.i.getSelection();
    ArrayList localArrayList1 = new ArrayList(arrayOfTableItem.length);
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
    {
      ArrayList localArrayList2 = new ArrayList(3);
      localArrayList2.add(arrayOfTableItem[i1].getText(0));
      localArrayList2.add(arrayOfTableItem[i1].getText(1));
      localArrayList2.add(arrayOfTableItem[i1].getText(2));
      localArrayList1.add(localArrayList2);
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localArrayList1 }, new Transfer[] { com.flagleader.builder.widget.c.a() });
  }

  public void g()
  {
    TableItem[] arrayOfTableItem = this.i.getSelection();
    ArrayList localArrayList1 = new ArrayList(arrayOfTableItem.length);
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
    {
      ArrayList localArrayList2 = new ArrayList(3);
      localArrayList2.add(arrayOfTableItem[i1].getText(0));
      localArrayList2.add(arrayOfTableItem[i1].getText(1));
      localArrayList2.add(arrayOfTableItem[i1].getText(2));
      localArrayList1.add(localArrayList2);
      arrayOfTableItem[i1].dispose();
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localArrayList1 }, new Transfer[] { com.flagleader.builder.widget.c.a() });
    this.l = true;
  }

  public void h()
  {
    TableItem[] arrayOfTableItem = this.i.getSelection();
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
      arrayOfTableItem[i1].dispose();
    this.l = true;
  }

  public boolean i()
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(com.flagleader.builder.widget.c.a());
    if ((localObject != null) && ((localObject instanceof ArrayList)))
    {
      ArrayList localArrayList = (ArrayList)localObject;
      for (int i1 = 0; i1 < localArrayList.size(); i1++)
      {
        if (!(localArrayList.get(i1) instanceof ArrayList))
          continue;
        TableItem localTableItem = new TableItem(this.i, 0);
        localTableItem.setText(new String[] { String.valueOf(((ArrayList)localArrayList.get(i1)).get(0)), String.valueOf(((ArrayList)localArrayList.get(i1)).get(1)), String.valueOf(((ArrayList)localArrayList.get(i1)).get(2)) });
        this.l = true;
      }
      return true;
    }
    return false;
  }

  public boolean j()
  {
    return this.l;
  }

  public String k()
  {
    return this.s;
  }

  public long l()
  {
    return this.t;
  }

  public List m()
  {
    return this.j;
  }

  public String n()
  {
    return this.a;
  }

  public String o()
  {
    return this.b;
  }

  public int p()
  {
    return this.u;
  }

  public int q()
  {
    return this.v;
  }

  public int r()
  {
    return this.w;
  }

  public void d(int paramInt)
  {
    this.w = paramInt;
  }

  protected void createButtonsForButtonBar(Composite paramComposite)
  {
    createButton(paramComposite, 0, b("Ok"), true);
    createButton(paramComposite, 1, b("Cancel"), false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.TestRuleServerDialog
 * JD-Core Version:    0.6.0
 */