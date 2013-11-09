package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.lang.AbstractCustomMethod;
import com.flagleader.repository.lang.GlobalMethod;
import com.flagleader.repository.lang.TypeMethod;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class i extends r
{
  private List b = new ArrayList();
  private List c = new ArrayList();
  private List d = new ArrayList();
  private com.flagleader.builder.widget.i e = new com.flagleader.builder.widget.i(true, true);
  private int f = 800;
  private int g = 600;
  private int h = 50;
  private int i = -1;
  Tree a;
  private Table j;

  public i(Shell paramShell, Iterator paramIterator)
  {
    super(paramShell);
    this.d.add(a("empty.AddSubTypeMethodDialog"));
    while (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      this.b.add(localObject);
      a((AbstractCustomMethod)localObject);
    }
    super.setShellStyle(1168);
  }

  private void a(AbstractCustomMethod paramAbstractCustomMethod)
  {
    String str = StringUtil.stringValue(paramAbstractCustomMethod.getTypeName());
    if (str.length() == 0)
      str = a("empty.AddSubTypeMethodDialog");
    for (int k = 0; k < this.d.size(); k++)
      if (this.d.get(k).equals(str))
        return;
    this.d.add(str);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddSubTypeMethodDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(h.a(1));
    GridData localGridData = new GridData(this.f, this.g);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localComposite2.setLayoutData(localGridData);
    SashForm localSashForm = new SashForm(localComposite2, 256);
    localSashForm.setLayout(h.a(1));
    localSashForm.setLayoutData(new GridData(1808));
    Composite localComposite3 = new Composite(localSashForm, 2048);
    localComposite3.setBackground(h.d);
    localComposite3.setLayout(h.a(1));
    localComposite3.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder1 = new CTabFolder(localComposite3, 8389504);
    localCTabFolder1.setLayoutData(new GridData(1808));
    CTabItem localCTabItem1 = new CTabItem(localCTabFolder1, 0);
    localCTabItem1.setText(a("typename.AddSubTypeMethodDialog"));
    localCTabItem1.setControl(a(localCTabFolder1));
    localCTabFolder1.setSelection(localCTabItem1);
    Composite localComposite4 = new Composite(localSashForm, 2048);
    localComposite4.setBackground(h.d);
    localComposite4.setLayout(h.a(1));
    localComposite4.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder2 = new CTabFolder(localComposite4, 8389504);
    localCTabFolder2.setLayoutData(new GridData(1808));
    CTabItem localCTabItem2 = new CTabItem(localCTabFolder2, 0);
    localCTabItem2.setText(a("method.AddSubTypeMethodDialog"));
    localCTabItem2.setControl(b(localCTabFolder2));
    localCTabFolder2.setSelection(localCTabItem2);
    localSashForm.setWeights(new int[] { 10, 80 });
    Button localButton = new Button(localComposite2, 32);
    localButton.setText(a("selectall.dialog"));
    localButton.addSelectionListener(new j(this, localButton));
    return localComposite1;
  }

  private Composite a(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.a = new s().a(localComposite, 2820);
    this.a.setHeaderVisible(false);
    this.a.setLayoutData(new GridData(1808));
    this.a.addSelectionListener(new k(this));
    for (int k = 0; k < this.d.size(); k++)
    {
      TreeItem localTreeItem = new TreeItem(this.a, 0);
      localTreeItem.setText(this.d.get(k).toString());
    }
    return localComposite;
  }

  private void a(Object paramObject)
  {
    TableItem localTableItem = new TableItem(this.j, 0);
    Object localObject;
    if ((paramObject instanceof TypeMethod))
    {
      localObject = (TypeMethod)paramObject;
      localTableItem.setData(localObject);
      a(localTableItem, false, ((TypeMethod)localObject).getDisName(), ((TypeMethod)localObject).getReturnType(), ((TypeMethod)localObject).getFuncName(), ((TypeMethod)localObject).getFuncBody());
    }
    else if ((paramObject instanceof GlobalMethod))
    {
      localObject = (GlobalMethod)paramObject;
      localTableItem.setData(localObject);
      a(localTableItem, false, ((GlobalMethod)localObject).getDisName(), ((GlobalMethod)localObject).getReturnType(), ((GlobalMethod)localObject).getFuncName(), ((GlobalMethod)localObject).getFuncBody());
    }
  }

  private void b(String paramString)
  {
    this.j.removeAll();
    if ((paramString == null) || (paramString.equals(a("empty.ListRulePackageDialog"))))
      k = 0;
    while (true)
    {
      a(this.b.get(k));
      k++;
      if (this.b == null)
        break;
      if (k < this.b.size())
        continue;
      break;
      for (k = 0; (this.b != null) && (k < this.b.size()); k++)
      {
        if (!((AbstractCustomMethod)this.b.get(k)).getTypeName().equals(paramString))
          continue;
        a(this.b.get(k));
      }
    }
    for (int k = 0; k < this.j.getColumnCount(); k++)
      this.j.getColumn(k).pack();
  }

  private Composite b(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.j = this.e.a(localComposite, 67618);
    this.j.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.AddSubTypeMethodDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.AddSubTypeMethodDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.AddSubTypeMethodDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int k = 0; k < arrayOfString3.length; k++)
      arrayOfInt[k] = Integer.parseInt(arrayOfString3[k]);
    for (k = 0; k < arrayOfString1.length; k++)
      arrayOfString1[k] = a(arrayOfString1[k] + ".AddSubTypeMethodDialog");
    this.e.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.j.setHeaderVisible(true);
    this.j.setLayoutData(new GridData(1808));
    b(null);
    return localComposite;
  }

  private void a(TableItem paramTableItem, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramTableItem.setText(0, paramString1);
    paramTableItem.setText(1, paramString2);
    paramTableItem.setText(2, paramString3);
    paramTableItem.setText(3, paramString4);
    paramTableItem.setChecked(paramBoolean);
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.j.getItems();
    this.c.clear();
    for (int k = 0; k < arrayOfTableItem.length; k++)
    {
      if (!arrayOfTableItem[k].getChecked())
        continue;
      this.c.add(arrayOfTableItem[k].getData());
    }
    super.okPressed();
  }

  public List a()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.i
 * JD-Core Version:    0.6.0
 */