package com.flagleader.builder.c;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class a extends v
{
  private Table a;
  private Menu h;

  public a(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    super(paramITreeNode, paramComposite, parambu);
  }

  protected Composite a(Composite paramComposite)
  {
    return b(super.a(paramComposite));
  }

  private Composite b(Composite paramComposite)
  {
    f(paramComposite);
    b(this.a);
    a(this.a);
    if ((a().isDevelopModel()) && (!a().isLocked()))
      this.a.addMouseListener(new b(this));
    return this.a;
  }

  public void update()
  {
    if ((needUpdate()) && (this.a != null) && (!this.a.isDisposed()))
    {
      this.a.removeAll();
      Control[] arrayOfControl = this.a.getChildren();
      for (int i = 0; i < arrayOfControl.length; i++)
        arrayOfControl[i].dispose();
      a(this.a);
      super.update();
    }
  }

  private Table f(Composite paramComposite)
  {
    this.a = new Table(paramComposite, 67588);
    GridData localGridData = new GridData(1808);
    this.a.setLayoutData(localGridData);
    this.a.setLinesVisible(true);
    return this.a;
  }

  private void a(Table paramTable)
  {
    if (a().getClassDirs().length > 0)
    {
      String[] arrayOfString = a().getClassDirs();
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

  private Envionment a()
  {
    if ((d() != null) && ((d() instanceof Envionment)))
      return (Envionment)d();
    return null;
  }

  public String getCompositeUuid()
  {
    return d().getEditUuid() + "props1";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.a
 * JD-Core Version:    0.6.0
 */