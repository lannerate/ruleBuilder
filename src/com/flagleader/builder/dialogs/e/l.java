package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.Envionment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class l extends r
{
  private Envionment a = null;
  private List b = new ArrayList();
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private Button g;
  private Button h;
  private Button i;
  private Button j;
  private int k = 0;
  private Tree l;

  public l(Shell paramShell, Envionment paramEnvionment, int paramInt)
  {
    super(paramShell);
    this.a = paramEnvionment;
    this.k = paramInt;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadTableFieldsDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(550, 350));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite1.setLayout(localGridLayout);
    this.l = new s().a(localComposite2, 67618);
    this.l.setLayoutData(new GridData(1808));
    this.l.setHeaderVisible(true);
    this.l.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadTableFieldsDialog");
    while (this.l.getColumnCount() > 0)
      this.l.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int m = 0; m < arrayOfString1.length; m++)
      arrayOfString2[m] = ResourceTools.getMessage(arrayOfString1[m] + ".LoadTableFieldsDialog");
    for (m = 0; m < arrayOfString2.length; m++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.l, 8388608);
      localTreeColumn.setText(arrayOfString2[m]);
      if (m == 0)
        localTreeColumn.setWidth(230);
      else
        localTreeColumn.setWidth(150);
    }
    this.l.setLayoutData(new GridData(1808));
    Iterator localIterator = this.a.getEnvionment().getAcceptElements(new m(this));
    while (localIterator.hasNext())
      a((SheetTable)localIterator.next());
    this.l.addSelectionListener(new n(this));
    this.h = new Button(localComposite1, 32);
    this.h.setText(a("insert.LoadTableFieldsDialog"));
    return localComposite1;
  }

  private void a(SheetTable paramSheetTable)
  {
    TreeItem localTreeItem1 = new TreeItem(this.l, 0);
    localTreeItem1.setText(0, paramSheetTable.getDisplayName());
    localTreeItem1.setData(paramSheetTable);
    List localList = paramSheetTable.getFields();
    for (int m = 0; m < localList.size(); m++)
    {
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)localList.get(m);
      TreeItem localTreeItem2 = new TreeItem(localTreeItem1, 0);
      localTreeItem2.setData(localSheetFieldModel);
      localTreeItem2.setText(0, localSheetFieldModel.getDisplayName());
      localTreeItem2.setText(1, localSheetFieldModel.getFieldName());
      localTreeItem2.setText(2, localSheetFieldModel.getValueType());
    }
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem1 = this.l.getItems();
    this.b.clear();
    for (int m = 0; m < arrayOfTreeItem1.length; m++)
    {
      if (!(arrayOfTreeItem1[m].getData() instanceof SheetTable))
        continue;
      TreeItem[] arrayOfTreeItem2 = arrayOfTreeItem1[m].getItems();
      for (int n = 0; n < arrayOfTreeItem2.length; n++)
      {
        if ((!arrayOfTreeItem2[n].getChecked()) || (!(arrayOfTreeItem2[n].getData() instanceof SheetFieldModel)))
          continue;
        this.b.add(arrayOfTreeItem2[n].getData());
      }
    }
    this.d = this.h.getSelection();
    super.okPressed();
  }

  public List a()
  {
    return this.b;
  }

  public boolean b()
  {
    return this.f;
  }

  public boolean c()
  {
    return this.d;
  }

  public boolean d()
  {
    return this.e;
  }

  public boolean e()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.l
 * JD-Core Version:    0.6.0
 */