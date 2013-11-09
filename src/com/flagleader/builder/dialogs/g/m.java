package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.builder.widget.s;
import com.flagleader.manager.a.a.c;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class m extends com.flagleader.builder.dialogs.r
{
  private List a = new ArrayList();
  private i b = new i(true, true);
  private String c = null;
  private List d;
  private BuilderManager e = null;
  private int f = 0;
  private List g = new ArrayList();
  private Table h;
  private Tree i;
  private Button j;
  private boolean k = false;

  public m(BuilderManager paramBuilderManager, String paramString, int paramInt)
  {
    super(paramBuilderManager.getShell());
    this.c = paramString;
    this.e = paramBuilderManager;
    this.f = paramInt;
    super.setShellStyle(1168);
  }

  private void a(List paramList)
  {
    if (paramList.size() > 9)
    {
      String str = StringUtil.stringValue(paramList.get(9));
      if (str.length() == 0)
        str = a("empty.ListRulePackageDialog");
      for (int m = 0; m < this.g.size(); m++)
        if (this.g.get(m).equals(str))
          return;
      this.g.add(str);
    }
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadRuleVersionsDialog"));
    this.d = d();
    this.g.add(a("empty.ListRulePackageDialog"));
    for (int m = 0; m < this.d.size(); m++)
      a((List)this.d.get(m));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(h.a(1));
    GridData localGridData = new GridData(800, 650);
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
    localCTabItem1.setText(a("projectname.ListRulePackageDialog"));
    localCTabItem1.setControl(a(localCTabFolder1));
    localCTabFolder1.setSelection(localCTabItem1);
    Composite localComposite4 = new Composite(localSashForm, 2048);
    localComposite4.setBackground(h.d);
    localComposite4.setLayout(h.a(1));
    localComposite4.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder2 = new CTabFolder(localComposite4, 8389504);
    localCTabFolder2.setLayoutData(new GridData(1808));
    CTabItem localCTabItem2 = new CTabItem(localCTabFolder2, 0);
    localCTabItem2.setText(a("package.ListRulePackageDialog"));
    localCTabItem2.setControl(b(localCTabFolder2));
    localCTabFolder2.setSelection(localCTabItem2);
    localSashForm.setWeights(new int[] { 20, 80 });
    Button localButton = new Button(localComposite2, 32);
    localButton.setText(a("selectall.dialog"));
    localButton.addSelectionListener(new n(this, localButton));
    this.j = new Button(localComposite2, 32);
    this.j.setText(a("lockcheckout.RulePackageProperties"));
    return localComposite1;
  }

  private Composite a(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.i = new s().a(localComposite, 2820);
    this.i.setHeaderVisible(false);
    this.i.setLayoutData(new GridData(1808));
    this.i.addSelectionListener(new o(this));
    for (int m = 0; m < this.g.size(); m++)
    {
      TreeItem localTreeItem = new TreeItem(this.i, 0);
      localTreeItem.setText(this.g.get(m).toString());
    }
    return localComposite;
  }

  private void a(TreeItem paramTreeItem)
  {
    if (paramTreeItem != null)
      b(paramTreeItem.getText());
  }

  private void b(String paramString)
  {
    this.h.removeAll();
    int m;
    if ((paramString == null) || (paramString.equals(a("empty.ListRulePackageDialog"))))
      m = 0;
    while (true)
    {
      TableItem localTableItem = new TableItem(this.h, 0);
      List localList = (List)this.d.get(m);
      localTableItem.setData(localList);
      a(localTableItem, localList);
      m++;
      if (this.d == null)
        break;
      if (m < this.d.size())
        continue;
      break;
      for (m = 0; (this.d != null) && (m < this.d.size()); m++)
      {
        if ((((List)this.d.get(m)).size() <= 9) || (!paramString.equals(((List)this.d.get(m)).get(9))))
          continue;
        localTableItem = new TableItem(this.h, 0);
        localList = (List)this.d.get(m);
        localTableItem.setData(localList);
        a(localTableItem, localList);
      }
    }
  }

  public TreeItem a()
  {
    if ((this.i != null) && (this.i.getSelection() != null) && (this.i.getSelection().length > 0))
      return this.i.getSelection()[0];
    return null;
  }

  private Composite b(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.h = this.b.a(localComposite, 67618);
    this.h.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("Columns.LoadRuleVersionsDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("Types.LoadRuleVersionsDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.LoadRuleVersionsDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int m = 0; m < arrayOfString3.length; m++)
      arrayOfInt[m] = Integer.parseInt(arrayOfString3[m]);
    for (m = 0; m < arrayOfString1.length; m++)
      arrayOfString1[m] = a(arrayOfString1[m] + ".LoadRuleVersionsDialog");
    this.b.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.h.setHeaderVisible(true);
    this.h.setLayoutData(new GridData(1808));
    for (m = 0; (this.d != null) && (m < this.d.size()); m++)
    {
      List localList = (List)this.d.get(m);
      TableItem localTableItem = new TableItem(this.h, 0);
      localTableItem.setData(localList);
      a(localTableItem, localList);
    }
    b(null);
    return localComposite;
  }

  private void a(TableItem paramTableItem, List paramList)
  {
    for (int m = 0; m < paramList.size(); m++)
      paramTableItem.setText(m, StringUtil.stringValue(paramList.get(m)));
  }

  private List d()
  {
    try
    {
      c localc = this.e.getRulesManager().p();
      List localList = localc.a(this.f, this.c);
      if (localList != null)
        return localList;
      MessageDialog.openError(getShell(), "", localc.i());
      return Collections.EMPTY_LIST;
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getLocalizedMessage());
    }
    return Collections.EMPTY_LIST;
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.h.getItems();
    this.a.clear();
    for (int m = 0; m < arrayOfTableItem.length; m++)
    {
      if (!arrayOfTableItem[m].getChecked())
        continue;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(arrayOfTableItem[m].getText(2));
      localArrayList.add(arrayOfTableItem[m].getText(3));
      localArrayList.add(arrayOfTableItem[m].getText(8));
      localArrayList.add(arrayOfTableItem[m].getText(0));
      this.a.add(localArrayList);
    }
    if (this.a.size() != 1)
    {
      this.e.showError(ResourceTools.getMessage("error.LoadRuleVersionsDialog"));
      return;
    }
    this.k = this.j.getSelection();
    super.okPressed();
  }

  public boolean b()
  {
    return this.k;
  }

  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public List c()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.m
 * JD-Core Version:    0.6.0
 */