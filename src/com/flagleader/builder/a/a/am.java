package com.flagleader.builder.a.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.a;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.TableModel;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class am extends a
  implements IElementViewer
{
  private static final String e = "columns.TableFKView";
  private TableModel f;
  private Table g;

  public am(TableModel paramTableModel, Composite paramComposite, bu parambu)
  {
    super(paramTableModel, paramComposite, parambu);
    this.f = paramTableModel;
    e();
    f();
  }

  public void e()
  {
    this.g = new Table(this.b, 66304);
    this.g.setLayoutData(new GridData(1808));
    this.g.setHeaderVisible(true);
    this.g.setLinesVisible(true);
  }

  public void f()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.TableFKView");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.TableFKView");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      TableColumn localTableColumn = new TableColumn(this.g, 8388608);
      localTableColumn.setText(ResourceTools.getMessage(arrayOfString1[i] + ".TableFKView"));
      localTableColumn.setWidth(Integer.parseInt(arrayOfString2[i]));
    }
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.g.removeAll();
    Control[] arrayOfControl = this.g.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    for (i = 0; i < this.f.getFKModels().size(); i++)
    {
      if (!(this.f.getFKModels().get(i) instanceof FKModel))
        continue;
      FKModel localFKModel = (FKModel)this.f.getFKModels().get(i);
      TableItem localTableItem = new TableItem(this.g, 0);
      localTableItem.setText(new String[] { localFKModel.getPkTableName(), localFKModel.getPkFieldNames(), localFKModel.getFKTableName(), localFKModel.getFkFieldNames() });
      localTableItem.setData(localFKModel);
    }
    super.update();
  }

  public String getCompositeUuid()
  {
    return this.f.getEditUuid() + "fk";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.am
 * JD-Core Version:    0.6.0
 */