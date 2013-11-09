package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.engine.IRuleContext;
import com.flagleader.repository.d.w;
import com.flagleader.repository.e.d;
import com.flagleader.repository.lang.b;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.server.RuleExecuteInfo;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class M extends f
{
  private static final int e = 380;
  private static final int f = 200;
  private Table g;
  private List h;
  private HashMap i = new HashMap();
  private boolean j = false;
  private TableEditor k;
  private TableItem l;
  private Text m;
  private Text n;
  private Text o;
  private Text p;
  private Text q;
  private Combo r;
  private Combo s;
  private String t;
  private String u;
  private String v;
  private String w;
  private long x;
  private int y;
  private int z;
  private int A;
  Label a;
  Label b;
  Label c;
  public static String[] d = com.flagleader.manager.d.c.d("planTypes.RuleExecuteViewer");

  static
  {
    for (int i1 = 0; i1 < d.length; i1++)
      d[i1] = com.flagleader.manager.d.c.b(d[i1] + ".RuleExecuteViewer");
  }

  public M()
  {
    super(Display.getCurrent().getActiveShell());
    this.x = 1000L;
    this.y = 0;
    this.z = 0;
    this.t = "";
    this.u = "";
    this.w = "";
    this.v = "";
    this.h = new ArrayList(0);
  }

  public M(RuleExecuteInfo paramRuleExecuteInfo)
  {
    super(Display.getCurrent().getActiveShell());
    this.h = paramRuleExecuteInfo.getPropertiesList();
    this.u = paramRuleExecuteInfo.getExeRuleName();
    this.x = paramRuleExecuteInfo.getInternalTime();
    this.t = paramRuleExecuteInfo.getDisplayName();
    this.y = paramRuleExecuteInfo.getPlanType();
    this.v = paramRuleExecuteInfo.getSpecialDay();
    this.w = paramRuleExecuteInfo.getSpecialTime();
    this.A = paramRuleExecuteInfo.getTracelogtype();
    this.z = paramRuleExecuteInfo.getState();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(3));
    this.m = a(localComposite2, "exeRuleName.RuleExecuteViewer", 2048, 240, 12, 2);
    this.m.setText(this.u);
    this.m.selectAll();
    Button localButton = g(localComposite2);
    localButton.setText(b("LoadRPK.RuleExecuteViewer"));
    localButton.addSelectionListener(new N(this));
    localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    this.n = a(localComposite2, "disName.RuleExecuteViewer", 2048, 300, 12, 2);
    this.n.setText(this.t);
    this.s = b(localComposite2, "tracelogtype.ServerSettingDialog", 2048, 280, 12, 2);
    this.s.setItems(new String[] { ResourceTools.getMessage("notracelog.ServerSettingDialog"), ResourceTools.getMessage("tracelog.ServerSettingDialog") });
    this.s.select(this.A);
    this.r = b(localComposite2, "plan.RuleExecuteViewer", 2048, 280, 12, 2);
    this.r.setItems(d);
    this.r.setVisibleItemCount(d.length);
    this.r.addSelectionListener(new R(this));
    Group localGroup = new Group(localComposite1, 16777216);
    localGroup.setLayout(a(2));
    localGroup.setLayoutData(a(400, 80));
    localGroup.setText(com.flagleader.manager.d.c.b("planSetting.RuleExecuteViewer"));
    this.a = a(localGroup, "internalMillis.RuleExecuteViewer");
    this.o = b(localGroup, 2048, 300, 12);
    this.c = a(localGroup, "specialHour.RuleExecuteViewer");
    this.q = b(localGroup, 2048, 300, 12);
    this.b = a(localGroup, "specialDate.RuleExecuteViewer");
    this.p = b(localGroup, 2048, 300, 12);
    this.r.select(this.y);
    e(this.y);
    this.o.setText(String.valueOf(this.x));
    this.p.setText(String.valueOf(this.v));
    this.q.setText(String.valueOf(this.w));
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

  private void e(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
      this.a.setText(b("internalMillis.RuleExecuteViewer"));
      this.o.setText("1000");
      this.b.setVisible(false);
      this.p.setVisible(false);
      this.c.setVisible(false);
      this.q.setVisible(false);
      break;
    case 1:
      this.a.setText(b("internalSeconds.RuleExecuteViewer"));
      this.o.setText("1");
      this.b.setVisible(false);
      this.p.setVisible(false);
      this.c.setVisible(false);
      this.q.setVisible(false);
      this.p.setText("");
      this.q.setText("");
      break;
    case 2:
      this.a.setText(b("internalHours.RuleExecuteViewer"));
      this.o.setText("1");
      this.b.setVisible(false);
      this.p.setVisible(false);
      this.c.setVisible(true);
      this.q.setVisible(true);
      this.c.setText(b("specialSecond.RuleExecuteViewer"));
      this.p.setText("");
      this.q.setText("00:00");
      break;
    case 3:
      this.a.setText(b("internalDays.RuleExecuteViewer"));
      this.o.setText("1");
      this.b.setVisible(false);
      this.p.setVisible(false);
      this.c.setVisible(true);
      this.q.setVisible(true);
      this.c.setText(b("specialHour.RuleExecuteViewer"));
      this.p.setText("");
      this.q.setText("00:00:00");
      break;
    case 4:
      this.a.setText(b("internalWeeks.RuleExecuteViewer"));
      this.o.setText("1");
      this.b.setVisible(true);
      this.p.setVisible(true);
      this.b.setText(b("specialWeeks.RuleExecuteViewer"));
      this.c.setVisible(true);
      this.q.setVisible(true);
      this.c.setText(b("specialHour.RuleExecuteViewer"));
      this.p.setText("1");
      this.q.setText("00:00:00");
      break;
    case 5:
      this.a.setText(b("internalMonths.RuleExecuteViewer"));
      this.o.setText("1");
      this.b.setVisible(true);
      this.p.setVisible(true);
      this.b.setText(b("specialDay.RuleExecuteViewer"));
      this.c.setVisible(true);
      this.q.setVisible(true);
      this.c.setText(b("specialHour.RuleExecuteViewer"));
      this.p.setText("1");
      this.q.setText("00:00:00");
      break;
    case 6:
      this.a.setText(b("afterSeconds.RuleExecuteViewer"));
      this.o.setText("0");
      this.b.setVisible(true);
      this.p.setVisible(true);
      this.b.setText(b("specialDate.RuleExecuteViewer"));
      this.c.setVisible(true);
      this.q.setVisible(true);
      this.c.setText(b("specialHour.RuleExecuteViewer"));
      this.p.setText("");
      this.q.setText("");
    }
  }

  private void t()
  {
    String[] arrayOfString = { "*.rsc", "*.rpk" };
    FileDialog localFileDialog = new FileDialog(getShell());
    localFileDialog.setFilterExtensions(arrayOfString);
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
        this.m.setText(((RulePackage)localObject1).getExeRulePackageName());
        this.n.setText(((RulePackage)localObject1).getDisplayName());
        this.g.removeAll();
        localObject2 = ((RulePackage)localObject1).getEnvionment().getAllMappingVariable();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MappingVariable)((Iterator)localObject2).next();
          if (((MappingVariable)localObject3).getInout() == 2)
            continue;
          TableItem localTableItem1 = new TableItem(this.g, 0);
          localTableItem1.setText(new String[] { ((MappingVariable)localObject3).getValueName(), StringUtil.stringValue(((MappingVariable)localObject3).getTypeManager().d(((MappingVariable)localObject3).getValueType())) });
        }
      }
      else
      {
        localObject1 = new w().a(localFile.toURL());
        this.m.setText(((IRuleContext)localObject1).getRuleName());
        this.n.setText(((IRuleContext)localObject1).getDescription());
        this.g.removeAll();
        localObject2 = ((IRuleContext)localObject1).getInputs();
        localObject3 = ((IRuleContext)localObject1).getValueTypes();
        for (int i1 = 0; (localObject2 != null) && (i1 < localObject2.length); i1++)
        {
          TableItem localTableItem2 = new TableItem(this.g, 0);
          String str = "string";
          if ((localObject3 != null) && (((Map)localObject3).get(localObject2[i1]) != null))
            str = ((Map)localObject3).get(localObject2[i1]).toString();
          localTableItem2.setText(new String[] { localObject2[i1], StringUtil.stringValue(b.a().b().d(str)) });
        }
      }
      this.j = true;
    }
    catch (Exception localException)
    {
      EngineLogger.getSqlLogger().error(localException.getMessage());
    }
  }

  private void d(Composite paramComposite)
  {
    f(paramComposite);
    b(this.g);
    a(this.g);
    this.k = new TableEditor(this.g);
    this.g.addKeyListener(new S(this));
    this.g.addMouseMoveListener(new T(this));
    this.g.addMouseListener(new U(this));
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(this.g.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.l, paramInt);
    paramText.addFocusListener(new V(this, paramText, paramTableItem, paramInt, paramTableEditor));
    paramText.addTraverseListener(new W(this, paramText, paramTableItem, paramInt, paramTableEditor));
  }

  private void e(Composite paramComposite)
  {
    Button localButton1 = g(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new X(this));
    Button localButton2 = g(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new Y(this));
    Button localButton3 = g(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new O(this));
    localButton1 = g(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new P(this));
    Button localButton4 = g(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new Q(this));
  }

  private Table f(Composite paramComposite)
  {
    this.g = new Table(paramComposite, 67586);
    GridData localGridData = new GridData();
    localGridData.widthHint = 380;
    localGridData.heightHint = 200;
    this.g.setLayoutData(localGridData);
    this.g.setLinesVisible(true);
    return this.g;
  }

  private void a(Table paramTable)
  {
    if (this.h != null)
      for (int i1 = 0; i1 < this.h.size(); i1++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        AdvancedProperty localAdvancedProperty = (AdvancedProperty)this.h.get(i1);
        localTableItem.setText(new String[] { localAdvancedProperty.getKey(), localAdvancedProperty.getProperty() });
      }
  }

  private void b(Table paramTable)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("key.DataDialog"));
    localTableColumn.setWidth(180);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("value.DataDialog"));
    localTableColumn.setWidth(185);
  }

  private TableItem u()
  {
    if (this.g.getSelectionIndex() >= 0)
      return this.g.getSelection()[0];
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
    if (this.h.size() > 0)
      this.h.clear();
    TableItem[] arrayOfTableItem = this.g.getItems();
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
    {
      if (arrayOfTableItem[i1].getText(0).length() <= 0)
        continue;
      this.h.add(new AdvancedProperty(arrayOfTableItem[i1].getText(0), arrayOfTableItem[i1].getText(1)));
    }
    this.t = this.n.getText();
    this.x = NumberUtil.parseLong(this.o.getText());
    this.u = this.m.getText();
    this.v = this.p.getText();
    this.w = this.q.getText();
    this.y = this.r.getSelectionIndex();
    this.A = this.s.getSelectionIndex();
    if (((this.y == 2) || (this.y == 3)) && (this.w.length() == 0))
      return;
    if (((this.y == 4) || (this.y == 5)) && ((this.w.length() == 0) || (this.v.length() == 0)))
      return;
    if ((this.t.length() > 0) && (this.u.length() > 0))
      close();
  }

  protected void a()
  {
    close();
  }

  public boolean b()
  {
    return this.g.getSelectionCount() > 0;
  }

  public boolean c()
  {
    return this.g.getSelectionCount() > 0;
  }

  public boolean d()
  {
    return this.g.getSelectionCount() > 0;
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
    TableItem[] arrayOfTableItem = this.g.getSelection();
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
    TableItem[] arrayOfTableItem = this.g.getSelection();
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
    this.j = true;
  }

  public void h()
  {
    TableItem[] arrayOfTableItem = this.g.getSelection();
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
      arrayOfTableItem[i1].dispose();
    this.j = true;
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
        TableItem localTableItem = new TableItem(this.g, 0);
        localTableItem.setText(new String[] { String.valueOf(((ArrayList)localArrayList.get(i1)).get(0)), String.valueOf(((ArrayList)localArrayList.get(i1)).get(1)), String.valueOf(((ArrayList)localArrayList.get(i1)).get(2)) });
        this.j = true;
      }
      return true;
    }
    return false;
  }

  public boolean j()
  {
    return this.j;
  }

  public String k()
  {
    return this.t;
  }

  public String l()
  {
    return this.u;
  }

  public long m()
  {
    return this.x;
  }

  public List n()
  {
    return this.h;
  }

  public String o()
  {
    return this.v;
  }

  public String p()
  {
    return this.w;
  }

  public int q()
  {
    return this.y;
  }

  public int r()
  {
    return this.z;
  }

  public int s()
  {
    return this.A;
  }

  public void d(int paramInt)
  {
    this.A = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.M
 * JD-Core Version:    0.6.0
 */