package com.flagleader.builder.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.repository.tree.Envionment;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;

public class h extends r
{
  private static final int a = 400;
  private static final int b = 150;
  private Envionment c;
  private TreeItem d;
  private Table e;
  private boolean f = false;

  protected h(Shell paramShell)
  {
    super(paramShell);
  }

  public h(TreeItem paramTreeItem, Shell paramShell)
  {
    super(paramShell);
    this.d = paramTreeItem;
    if ((this.d.getData() != null) && ((this.d.getData() instanceof Envionment)))
      this.c = ((Envionment)this.d.getData());
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    super.setMessage(a("envionment.dialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    localComposite1.setLayout(a(1));
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(new GridLayout());
    localComposite2.setLayoutData(new GridData(1808));
    d(localComposite2);
    Composite localComposite3 = new Composite(localComposite1, 0);
    localComposite3.setLayoutData(new GridData(1808));
    localComposite3.setLayout(a(5));
    c(localComposite3);
    b(localComposite1);
    return localComposite1;
  }

  private void c(Composite paramComposite)
  {
    Button localButton = f(paramComposite);
    localButton.setText(ResourceTools.getMessage("addJar.EnvionmentDialog"));
    localButton.addSelectionListener(new i(this));
    localButton = f(paramComposite);
    localButton.setText(ResourceTools.getMessage("addDir.EnvionmentDialog"));
    localButton.addSelectionListener(new j(this));
    localButton = f(paramComposite);
    localButton.setText(ResourceTools.getMessage("delete.DataDialog"));
    localButton.addSelectionListener(new k(this));
    localButton = f(paramComposite);
    localButton.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton.addSelectionListener(new l(this));
    localButton = f(paramComposite);
    localButton.setText(ResourceTools.getMessage("moveDown.DataDialog"));
    localButton.addSelectionListener(new m(this));
    Label localLabel = new Label(paramComposite, 8388608);
    localLabel.setLayoutData(d(5));
  }

  private void d(Composite paramComposite)
  {
    e(paramComposite);
    b(this.e);
    a(this.e);
    this.e.addMouseListener(new n(this));
  }

  private Table e(Composite paramComposite)
  {
    this.e = new Table(paramComposite, 67588);
    GridData localGridData = new GridData();
    localGridData.widthHint = 400;
    localGridData.heightHint = 150;
    this.e.setLayoutData(localGridData);
    this.e.setLinesVisible(true);
    return this.e;
  }

  private void a(Table paramTable)
  {
    if (this.c.getClassDirs().length > 0)
    {
      String[] arrayOfString = this.c.getClassDirs();
      for (int i = 0; i < arrayOfString.length; i++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        localTableItem.setText(0, arrayOfString[i]);
      }
    }
  }

  private void b(Table paramTable)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(ResourceTools.getMessage("classpath.EnvionmentDialog"));
    localTableColumn.setWidth(400);
  }

  private Button f(Composite paramComposite)
  {
    Button localButton = new Button(paramComposite, 8);
    GridData localGridData = new GridData();
    localGridData.widthHint = 65;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.horizontalIndent = 16;
    localButton.setLayoutData(localGridData);
    return localButton;
  }

  private GridData d(int paramInt)
  {
    GridData localGridData = new GridData();
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.horizontalSpan = paramInt;
    return localGridData;
  }

  protected void a()
  {
    if (this.f)
    {
      List localList = this.c.getClassDirVector();
      localList.clear();
      TableItem[] arrayOfTableItem = this.e.getItems();
      for (int i = 0; i < arrayOfTableItem.length; i++)
        localList.add(arrayOfTableItem[i].getText(0));
      this.c.setModified(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.h
 * JD-Core Version:    0.6.0
 */