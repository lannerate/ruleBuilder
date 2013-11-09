package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class an extends com.flagleader.builder.a.an
  implements IElementViewer
{
  private static final int q = 3;
  private static final int r = 6;
  private static final int s = 8;
  private static final int t = 9;
  private static final int u = 10;
  private static final String v = "columns.TableFieldView";

  public an(TableModel paramTableModel, Composite paramComposite, bu parambu)
  {
    super(paramTableModel, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new an((TableModel)this.c, paramComposite, this.a);
  }

  protected void j()
  {
    super.j();
    if (!b())
      this.e.addMouseListener(new ao(this, null));
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "delete");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "copy");
    a(paramToolBar, "selectall");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new at(this));
    super.h();
  }

  protected void q()
  {
    try
    {
      if (r().refresh())
        update();
    }
    catch (Exception localException)
    {
      a().showError(localException.getLocalizedMessage());
    }
  }

  private TableModel r()
  {
    return (TableModel)this.c;
  }

  protected void i()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.TableFieldView");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.TableFieldView");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      TableColumn localTableColumn = new TableColumn(this.e, 8388608);
      localTableColumn.setText(ResourceTools.getMessage(arrayOfString1[i] + ".TableFieldView"));
      localTableColumn.setWidth(Integer.parseInt(arrayOfString2[i]));
    }
    this.e.setHeaderVisible(true);
  }

  protected void k()
  {
    for (int i = 0; i < r().getFields().size(); i++)
    {
      if (!(r().getFields().get(i) instanceof FieldModel))
        continue;
      FieldModel localFieldModel = (FieldModel)r().getFields().get(i);
      TableItem localTableItem = new TableItem(this.e, 0);
      String str = "{";
      AdvancedProperty[] arrayOfAdvancedProperty = localFieldModel.getAdvanceProperties();
      for (int j = 0; j < arrayOfAdvancedProperty.length; j++)
        str = str + arrayOfAdvancedProperty[j].toString() + ",";
      str = str + "}";
      localTableItem.setText(new String[] { i, localFieldModel.getFieldName(), localFieldModel.getFieldType(), localFieldModel.getValueType(), localFieldModel.getLen(), a(localFieldModel), localFieldModel.isPrimaryKey() ? "true" : "false", localFieldModel.isFriendKey() ? "true" : "false", localFieldModel.isReadOnly() ? "true" : "false", localFieldModel.getDisplayName(), localFieldModel.getDocument() });
      localTableItem.setData(localFieldModel);
    }
  }

  protected void a(TableItem paramTableItem)
  {
    FieldModel localFieldModel = (FieldModel)paramTableItem.getData();
    paramTableItem.setText(3, localFieldModel.getValueType());
    paramTableItem.setText(9, localFieldModel.getDisplayName());
    paramTableItem.setText(6, localFieldModel.isPrimaryKey() ? "true" : "false");
    paramTableItem.setText(8, localFieldModel.isReadOnly() ? "true" : "false");
    paramTableItem.setText(10, localFieldModel.getDocument());
  }

  private String a(FieldModel paramFieldModel)
  {
    if (paramFieldModel.isUnNull())
      return ResourceTools.getMessage("notnull.TEXT");
    return ResourceTools.getMessage("null.TEXT");
  }

  public boolean canDelete()
  {
    return this.e.getSelectionCount() > 0;
  }

  public void delete()
  {
    TableItem[] arrayOfTableItem = this.e.getSelection();
    if ((arrayOfTableItem != null) && (arrayOfTableItem.length > 0))
    {
      for (int i = 0; i < arrayOfTableItem.length; i++)
      {
        if ((arrayOfTableItem[i].getData() == null) || (!(arrayOfTableItem[i].getData() instanceof FieldModel)))
          continue;
        r().disposeField((FieldModel)arrayOfTableItem[i].getData());
        r().setModified(true);
      }
      update();
    }
  }

  public String getCompositeUuid()
  {
    return this.c.getEditUuid() + "field";
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean isCanSelectAll()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.an
 * JD-Core Version:    0.6.0
 */