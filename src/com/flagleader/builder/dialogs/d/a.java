package com.flagleader.builder.dialogs.d;

import com.flagleader.builder.ResourceTools;
import com.flagleader.export.PagesMessages;
import com.flagleader.export.Type;
import com.flagleader.repository.export.AbstractPropertyModel;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.util.ListUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class a extends com.flagleader.builder.dialogs.f
{
  private static final int a = 650;
  private static final int b = 400;
  private String[] c;
  private String[] d;
  private HashMap e = new HashMap();
  private Table f;
  private List g;
  private HashMap h = new HashMap();
  private AbstractPropertyModel i = null;
  private boolean j = false;
  private TableEditor k;
  private TableItem l;

  public PagesMessages a()
  {
    IPage localIPage = this.i.getPage();
    if (localIPage != null)
      return localIPage.getPreferences();
    return new PagesMessages(null, "pages");
  }

  public a(AbstractPropertyModel paramAbstractPropertyModel)
  {
    super(Display.getCurrent().getActiveShell());
    this.i = paramAbstractPropertyModel;
    e();
    this.g = paramAbstractPropertyModel.getPropertiesList();
    if (a().getStringArray("field.keys") != null)
      this.c = ListUtil.addArray(a().getStringArray("field.keys"), c());
    else
      this.c = c();
    if (a().getStringArray("field.values") != null)
      this.d = ListUtil.addArray(a().getStringArray("field.values"), d());
    else
      this.d = d();
    for (int m = 0; m < this.c.length; m++)
      this.e.put(this.c[m], this.d[m]);
  }

  public String[] b()
  {
    String[] arrayOfString1 = this.i.getPageTypes();
    ArrayList localArrayList = new ArrayList(arrayOfString1.length);
    for (int m = 0; m < arrayOfString1.length; m++)
    {
      String[] arrayOfString3 = a().getStringArray(arrayOfString1[m] + ".prop");
      if ((arrayOfString3 == null) || (arrayOfString3.length <= 0))
        continue;
      for (int i1 = 0; i1 < arrayOfString3.length; i1++)
      {
        if (this.h.get(arrayOfString3[i1]) != null)
          continue;
        this.h.put(arrayOfString3[i1], arrayOfString3[i1]);
        localArrayList.add(arrayOfString3[i1]);
      }
    }
    String[] arrayOfString2;
    if ((this.i.getParent() instanceof IPage))
    {
      if (a().getStringArray(((IPage)this.i.getParent()).getImportFile() + ".fprops") != null)
      {
        arrayOfString2 = a().getStringArray(((IPage)this.i.getParent()).getImportFile() + ".fprops");
        for (int n = 0; n < arrayOfString2.length; n++)
        {
          if ((this.h.get(arrayOfString2[n]) != null) || (arrayOfString2[n].endsWith("_")))
            continue;
          this.h.put(arrayOfString2[n], arrayOfString2[n]);
          localArrayList.add(arrayOfString2[n]);
        }
      }
    }
    else if ((this.i.getParent() instanceof PageFieldModel))
    {
      arrayOfString2 = (String[])null;
      PageFieldModel localPageFieldModel = (PageFieldModel)this.i.getParent();
      if (a().getStringArray(localPageFieldModel.getInputType() + ".fprops") != null)
        arrayOfString2 = a().getStringArray(localPageFieldModel.getInputType() + ".fprops");
      else if (a().getStringArray(localPageFieldModel.getResultType() + ".fprops") != null)
        arrayOfString2 = a().getStringArray(localPageFieldModel.getResultType() + ".fprops");
      a(arrayOfString2, this.h, localArrayList);
    }
    a(a().getStringArray("field.fprops"), this.h, localArrayList);
    return ListUtil.toStringArray(localArrayList);
  }

  private void a(String[] paramArrayOfString, HashMap paramHashMap, ArrayList paramArrayList)
  {
    if (paramArrayOfString != null)
      for (int m = 0; m < paramArrayOfString.length; m++)
      {
        if ((paramHashMap.get(paramArrayOfString[m]) != null) || (paramArrayOfString[m].endsWith("_")))
          continue;
        paramHashMap.put(paramArrayOfString[m], paramArrayOfString[m]);
        paramArrayList.add(paramArrayOfString[m]);
      }
  }

  public String[] c()
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = this.i.getPageTypes();
    ArrayList localArrayList = new ArrayList(arrayOfString1.length);
    for (int m = 0; m < arrayOfString1.length; m++)
    {
      String[] arrayOfString3 = a().getStringArray(arrayOfString1[m] + ".moreprop");
      if ((arrayOfString3 == null) || (arrayOfString3.length <= 0))
        continue;
      for (int i1 = 0; i1 < arrayOfString3.length; i1++)
      {
        if (localHashMap.get(arrayOfString3[i1]) != null)
          continue;
        localHashMap.put(arrayOfString3[i1], arrayOfString3[i1]);
        localArrayList.add(arrayOfString3[i1]);
      }
    }
    String[] arrayOfString2;
    if ((this.i.getParent() instanceof IPage))
    {
      if (a().getStringArray(((IPage)this.i.getParent()).getImportFile() + ".fprops") != null)
      {
        arrayOfString2 = a().getStringArray(((IPage)this.i.getParent()).getImportFile() + ".fprops");
        for (int n = 0; n < arrayOfString2.length; n++)
        {
          if ((localHashMap.get(arrayOfString2[n]) != null) || (!arrayOfString2[n].endsWith("_")))
            continue;
          localHashMap.put(arrayOfString2[n], arrayOfString2[n]);
          localArrayList.add(arrayOfString2[n]);
        }
      }
    }
    else if ((this.i.getParent() instanceof PageFieldModel))
    {
      arrayOfString2 = (String[])null;
      PageFieldModel localPageFieldModel = (PageFieldModel)this.i.getParent();
      if (a().getStringArray(localPageFieldModel.getInputType() + ".fprops") != null)
        arrayOfString2 = a().getStringArray(localPageFieldModel.getInputType() + ".fprops");
      else if (a().getStringArray(localPageFieldModel.getResultType() + ".fprops") != null)
        arrayOfString2 = a().getStringArray(localPageFieldModel.getResultType() + ".fprops");
      a(arrayOfString2, localHashMap, localArrayList);
    }
    a(a().getStringArray("field.fprops"), localHashMap, localArrayList);
    return ListUtil.toStringArray(localArrayList);
  }

  public String[] d()
  {
    String[] arrayOfString = c();
    for (int m = 0; m < arrayOfString.length; m++)
    {
      if (a().getString(arrayOfString[m] + ".view") == null)
        continue;
      arrayOfString[m] = a().getString(arrayOfString[m] + ".view");
    }
    return arrayOfString;
  }

  public void e()
  {
    String[] arrayOfString = b();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
      for (int m = 0; m < arrayOfString.length; m++)
      {
        if (this.i.getProperty(arrayOfString[m]) != null)
          continue;
        this.i.setPropertyValue(arrayOfString[m], a().getString(arrayOfString[m] + ".defaultvalue", ""));
      }
  }

  private List p()
  {
    ArrayList localArrayList = new ArrayList(this.g.size());
    if (this.g != null)
      for (int m = 0; m < this.g.size(); m++)
      {
        AdvancedProperty localAdvancedProperty = (AdvancedProperty)this.g.get(m);
        if (this.h.containsKey(localAdvancedProperty.getKey()))
          continue;
        int n = 1;
        for (int i1 = 0; i1 < this.c.length; i1++)
        {
          if (!localAdvancedProperty.getKey().startsWith(this.c[i1]))
            continue;
          n = 0;
          break;
        }
        if (n == 0)
          continue;
        localArrayList.add(localAdvancedProperty.getKey());
      }
    return localArrayList;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(new GridLayout());
    localComposite2.setLayoutData(new GridData(1808));
    d(localComposite2);
    Composite localComposite3 = new Composite(localComposite1, 0);
    localComposite3.setLayoutData(new GridData(1808));
    localComposite3.setLayout(a(7));
    e(localComposite3);
    b(localComposite1);
    return localComposite1;
  }

  private void a(StringBuffer paramStringBuffer)
  {
    for (int m = 0; (m < 10) && (paramStringBuffer.indexOf("]") > 0); m++)
    {
      int n = paramStringBuffer.indexOf("[");
      if ((n < 0) || (paramStringBuffer.indexOf("]", n) <= 0))
        continue;
      int i1 = paramStringBuffer.indexOf("]", n);
      String str = paramStringBuffer.substring(n + 1, i1);
      try
      {
        Integer.parseInt(str);
        if (((this.i.getParent() instanceof PageFieldModel)) && (((PageFieldModel)this.i.getParent()).getJavaType().isListList()))
        {
          paramStringBuffer.replace(n, i1 + 1, "<%=((java.util.List)" + ((PageFieldModel)this.i.getParent()).getVariableName() + ".get(i)).get(" + str + ")%>");
        }
        else
        {
          if ((!(this.i instanceof PageFieldModel)) || (!((PageFieldModel)this.i).getJavaType().isListList()))
            continue;
          paramStringBuffer.replace(n, i1 + 1, "<%=((java.util.List)" + ((PageFieldModel)this.i).getVariableName() + ".get(i)).get(" + str + ")%>");
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  private void d(Composite paramComposite)
  {
    f(paramComposite);
    b(this.f);
    a(this.f);
    this.k = new TableEditor(this.f);
    this.f.addKeyListener(new b(this));
    this.f.addMouseMoveListener(new f(this));
    this.f.addMouseListener(new g(this));
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(this.f.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.l, paramInt);
    paramText.addFocusListener(new h(this, paramText, paramTableItem, paramInt, paramTableEditor));
    paramText.addTraverseListener(new i(this, paramText, paramTableItem, paramInt, paramTableEditor));
  }

  private void e(Composite paramComposite)
  {
    Button localButton1 = g(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new j(this));
    Button localButton2 = g(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new k(this));
    Button localButton3 = g(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new l(this));
    localButton1 = g(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new m(this));
    Button localButton4 = g(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new c(this));
    localButton4 = g(paramComposite);
    localButton4.setText(b("copy.popup"));
    localButton4.addSelectionListener(new d(this));
    localButton4 = g(paramComposite);
    localButton4.setText(b("paste.popup"));
    localButton4.addSelectionListener(new e(this));
  }

  private Table f(Composite paramComposite)
  {
    this.f = new Table(paramComposite, 67586);
    GridData localGridData = new GridData();
    localGridData.widthHint = 650;
    localGridData.heightHint = 400;
    this.f.setLayoutData(localGridData);
    this.f.setLinesVisible(true);
    return this.f;
  }

  private void a(Table paramTable)
  {
    List localList = p();
    int m;
    if (localList.size() > 0)
      for (m = 0; m < localList.size(); m++)
        this.i.removeProperty(localList.get(m).toString());
    if (this.g != null)
      for (m = 0; m < this.g.size(); m++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        AdvancedProperty localAdvancedProperty = (AdvancedProperty)this.g.get(m);
        String str = "";
        if (a().getString(localAdvancedProperty.getKey() + ".view") != null)
          str = a().getString(localAdvancedProperty.getKey() + ".view");
        else
          for (int n = 0; n < this.c.length; n++)
          {
            if (!localAdvancedProperty.getKey().startsWith(this.c[n]))
              continue;
            str = this.d[n];
            break;
          }
        localTableItem.setText(new String[] { localAdvancedProperty.getKey(), localAdvancedProperty.getProperty(), str });
      }
  }

  private void b(Table paramTable)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("key.DataDialog"));
    localTableColumn.setWidth(115);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("value.DataDialog"));
    localTableColumn.setWidth(385);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("describe.DataDialog"));
    localTableColumn.setWidth(165);
  }

  private TableItem q()
  {
    if (this.f.getSelectionIndex() >= 0)
      return this.f.getSelection()[0];
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
    if (!this.i.isLocked())
    {
      if (this.g.size() > 0)
        this.g.clear();
      TableItem[] arrayOfTableItem = this.f.getItems();
      for (int m = 0; m < arrayOfTableItem.length; m++)
      {
        if (arrayOfTableItem[m].getText(0).length() <= 0)
          continue;
        this.g.add(new AdvancedProperty(arrayOfTableItem[m].getText(0), arrayOfTableItem[m].getText(1)));
      }
    }
    close();
  }

  protected void f()
  {
    close();
  }

  public boolean g()
  {
    return this.f.getSelectionCount() > 0;
  }

  public boolean h()
  {
    return this.f.getSelectionCount() > 0;
  }

  public boolean i()
  {
    return this.f.getSelectionCount() > 0;
  }

  public boolean j()
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(com.flagleader.builder.widget.c.a());
    if (localObject == null)
      return false;
    if ((localObject instanceof ArrayList))
    {
      ArrayList localArrayList = (ArrayList)localObject;
      for (int m = 0; m < localArrayList.size(); m++)
        if ((localArrayList.get(m) instanceof ArrayList))
          return true;
    }
    return false;
  }

  public void k()
  {
    TableItem[] arrayOfTableItem = this.f.getSelection();
    ArrayList localArrayList1 = new ArrayList(arrayOfTableItem.length);
    for (int m = 0; m < arrayOfTableItem.length; m++)
    {
      ArrayList localArrayList2 = new ArrayList(3);
      localArrayList2.add(arrayOfTableItem[m].getText(0));
      localArrayList2.add(arrayOfTableItem[m].getText(1));
      localArrayList2.add(arrayOfTableItem[m].getText(2));
      localArrayList1.add(localArrayList2);
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localArrayList1 }, new Transfer[] { com.flagleader.builder.widget.c.a() });
  }

  public void l()
  {
    TableItem[] arrayOfTableItem = this.f.getSelection();
    ArrayList localArrayList1 = new ArrayList(arrayOfTableItem.length);
    for (int m = 0; m < arrayOfTableItem.length; m++)
    {
      ArrayList localArrayList2 = new ArrayList(3);
      localArrayList2.add(arrayOfTableItem[m].getText(0));
      localArrayList2.add(arrayOfTableItem[m].getText(1));
      localArrayList2.add(arrayOfTableItem[m].getText(2));
      localArrayList1.add(localArrayList2);
      arrayOfTableItem[m].dispose();
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localArrayList1 }, new Transfer[] { com.flagleader.builder.widget.c.a() });
    this.j = true;
  }

  public void m()
  {
    TableItem[] arrayOfTableItem = this.f.getSelection();
    for (int m = 0; m < arrayOfTableItem.length; m++)
      arrayOfTableItem[m].dispose();
    this.j = true;
  }

  public boolean n()
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(com.flagleader.builder.widget.c.a());
    if ((localObject != null) && ((localObject instanceof ArrayList)))
    {
      ArrayList localArrayList = (ArrayList)localObject;
      for (int m = 0; m < localArrayList.size(); m++)
      {
        if (!(localArrayList.get(m) instanceof ArrayList))
          continue;
        TableItem localTableItem = new TableItem(this.f, 0);
        localTableItem.setText(new String[] { String.valueOf(((ArrayList)localArrayList.get(m)).get(0)), String.valueOf(((ArrayList)localArrayList.get(m)).get(1)), String.valueOf(((ArrayList)localArrayList.get(m)).get(2)) });
        this.j = true;
      }
      return true;
    }
    return false;
  }

  public boolean o()
  {
    return this.j;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.a
 * JD-Core Version:    0.6.0
 */