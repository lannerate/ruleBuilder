package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.i;
import com.flagleader.builder.widget.s;
import com.flagleader.util.ListUtil;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
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
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class f extends com.flagleader.builder.dialogs.f
{
  private List b = new ArrayList();
  private List c = null;
  private List d = new ArrayList();
  private i e = new i(true, true);
  private int f = 800;
  private int g = 600;
  private int h = 50;
  private int i = -1;
  Tree a;
  private BuilderManager j = null;
  private Table k;
  private Button l;
  private boolean m = false;

  public f(Shell paramShell, List paramList)
  {
    super(paramShell);
    this.c = paramList;
    this.d.add(b("empty.ListRulePackageDialog"));
    for (int n = 0; n < this.c.size(); n++)
      a((List)this.c.get(n));
    super.setShellStyle(1168);
  }

  private void a(List paramList)
  {
    String str = StringUtil.stringValue(paramList.get(3));
    if (str.length() == 0)
      str = b("empty.ListRulePackageDialog");
    for (int n = 0; n < this.d.size(); n++)
      if (this.d.get(n).equals(str))
        return;
    this.d.add(str);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    c(b("title.ListRulePackageDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(com.flagleader.builder.widget.h.a(1));
    GridData localGridData = new GridData(this.f, this.g);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localComposite2.setLayoutData(localGridData);
    SashForm localSashForm = new SashForm(localComposite2, 256);
    localSashForm.setLayout(com.flagleader.builder.widget.h.a(1));
    localSashForm.setLayoutData(new GridData(1808));
    Composite localComposite3 = new Composite(localSashForm, 2048);
    localComposite3.setBackground(com.flagleader.builder.widget.h.d);
    localComposite3.setLayout(com.flagleader.builder.widget.h.a(1));
    localComposite3.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder1 = new CTabFolder(localComposite3, 8389504);
    localCTabFolder1.setLayoutData(new GridData(1808));
    CTabItem localCTabItem1 = new CTabItem(localCTabFolder1, 0);
    localCTabItem1.setText(b("projectname.ListRulePackageDialog"));
    localCTabItem1.setControl(a(localCTabFolder1));
    localCTabFolder1.setSelection(localCTabItem1);
    Composite localComposite4 = new Composite(localSashForm, 2048);
    localComposite4.setBackground(com.flagleader.builder.widget.h.d);
    localComposite4.setLayout(com.flagleader.builder.widget.h.a(1));
    localComposite4.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder2 = new CTabFolder(localComposite4, 8389504);
    localCTabFolder2.setLayoutData(new GridData(1808));
    CTabItem localCTabItem2 = new CTabItem(localCTabFolder2, 0);
    localCTabItem2.setText(b("package.ListRulePackageDialog"));
    localCTabItem2.setControl(b(localCTabFolder2));
    localCTabFolder2.setSelection(localCTabItem2);
    localSashForm.setWeights(new int[] { 20, 80 });
    Button localButton = new Button(localComposite2, 32);
    localButton.setText(b("selectall.dialog"));
    localButton.addSelectionListener(new g(this, localButton));
    this.l = new Button(localComposite2, 32);
    this.l.setText(b("lockcheckout.RulePackageProperties"));
    return localComposite1;
  }

  private Composite a(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(com.flagleader.builder.widget.h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.a = new s().a(localComposite, 2820);
    this.a.setHeaderVisible(false);
    this.a.setLayoutData(new GridData(1808));
    this.a.addSelectionListener(new h(this));
    for (int n = 0; n < this.d.size(); n++)
    {
      TreeItem localTreeItem = new TreeItem(this.a, 0);
      localTreeItem.setText(this.d.get(n).toString());
    }
    return localComposite;
  }

  private void a(TreeItem paramTreeItem)
  {
    if (paramTreeItem != null)
      a(paramTreeItem.getText());
  }

  private void a(String paramString)
  {
    this.k.removeAll();
    int n;
    if ((paramString == null) || (paramString.equals(b("empty.ListRulePackageDialog"))))
      n = 0;
    while (true)
    {
      TableItem localTableItem = new TableItem(this.k, 0);
      List localList = (List)this.c.get(n);
      localTableItem.setData(localList);
      a(localTableItem, localList);
      n++;
      if (this.c == null)
        break;
      if (n < this.c.size())
        continue;
      break;
      for (n = 0; (this.c != null) && (n < this.c.size()); n++)
      {
        if (!((List)this.c.get(n)).get(3).equals(paramString))
          continue;
        localTableItem = new TableItem(this.k, 0);
        localList = (List)this.c.get(n);
        localTableItem.setData(localList);
        a(localTableItem, localList);
      }
    }
  }

  public TreeItem a()
  {
    if ((this.a != null) && (this.a.getSelection() != null) && (this.a.getSelection().length > 0))
      return this.a.getSelection()[0];
    return null;
  }

  private Composite b(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(com.flagleader.builder.widget.h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.k = this.e.a(localComposite, 67618);
    this.k.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ListRulePackageDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.ListRulePackageDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.ListRulePackageDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int n = 0; n < arrayOfString3.length; n++)
      arrayOfInt[n] = Integer.parseInt(arrayOfString3[n]);
    for (n = 0; n < arrayOfString1.length; n++)
      arrayOfString1[n] = b(arrayOfString1[n] + ".ListRulePackageDialog");
    this.e.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.k.setHeaderVisible(true);
    this.k.setLayoutData(new GridData(1808));
    a(null);
    return localComposite;
  }

  private void a(TableItem paramTableItem, List paramList)
  {
    for (int n = 0; n < paramList.size(); n++)
      paramTableItem.setText(n, StringUtil.stringValue(paramList.get(n)));
  }

  private String[] b(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      List localList = (List)paramList.get(0);
      return (String[])ListUtil.toArray(localList);
    }
    return new String[0];
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.k.getItems();
    this.b.clear();
    for (int n = 0; n < arrayOfTableItem.length; n++)
    {
      if (!arrayOfTableItem[n].getChecked())
        continue;
      this.b.add(arrayOfTableItem[n].getData());
    }
    this.m = this.l.getSelection();
    super.okPressed();
  }

  public boolean b()
  {
    return this.m;
  }

  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public List c()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.f
 * JD-Core Version:    0.6.0
 */