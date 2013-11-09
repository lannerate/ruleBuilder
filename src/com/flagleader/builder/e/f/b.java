package com.flagleader.builder.e.f;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.b.v;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.IElement;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.util.List;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class b extends com.flagleader.builder.e.a
{
  a a = null;
  private Tree c;
  private Text d;
  DBModel b = null;

  public b(a parama)
  {
    super("SelectDBSPage1");
    setTitle(b("title.SelectDBSPage1"));
    setDescription(b("describe.SelectDBSPage1"));
    this.a = parama;
  }

  protected void a(File paramFile)
  {
    try
    {
      DBModel localDBModel = com.flagleader.repository.e.c.a(paramFile);
      v localv = new v(getShell(), localDBModel.getTables());
      if (localv.open() == 0)
      {
        List localList1 = localv.a();
        this.b = new DBModel();
        this.b.setDriver(localDBModel.getDriver());
        this.b.setUrl(localDBModel.getUrl());
        this.b.setUserName(localDBModel.getUserName());
        this.b.setPasswd(localDBModel.getPasswd());
        this.b.setDatasourceName(localDBModel.getDisplayName());
        this.b.setDisplayName(localDBModel.getDisplayName());
        this.b.setSchemaName(localDBModel.getSchemaName());
        this.b.setCatalogName(localDBModel.getCatalogName());
        for (int i = 0; i < localList1.size(); i++)
        {
          TableModel localTableModel = (TableModel)localList1.get(i);
          List localList2 = localDBModel.getFKModels(localTableModel.getTableName());
          for (int j = 0; j < localList2.size(); j++)
            localTableModel.addChildElement((FKModel)localList2.get(j));
          this.b.addChildElement(localTableModel);
          TreeItem localTreeItem = new TreeItem(this.c, 0);
          a(localTreeItem, localTableModel);
        }
      }
    }
    catch (Exception localException)
    {
    }
  }

  public void createControl(Composite paramComposite)
  {
    Composite localComposite1 = new Composite(paramComposite, 0);
    localComposite1.setLayout(a(1));
    localComposite1.setLayoutData(a(550, 400));
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(3));
    this.d = a(localComposite2, "dbsfile.SelectDBSPage1", 2048, 280, 12, 2);
    Button localButton = a(localComposite2);
    localButton.setText(a("reset.DataDialog"));
    localButton.addSelectionListener(new c(this));
    this.c = new s().a(localComposite1, ".SelectDBSPage1", 68386);
    this.c.addSelectionListener(new d(this));
    setControl(localComposite1);
  }

  private Image a(ITreeNode paramITreeNode)
  {
    return ResourceTools.getIcon(paramITreeNode);
  }

  private void a(TreeItem paramTreeItem, IElement paramIElement)
  {
    if ((paramIElement instanceof ITreeNode))
      paramTreeItem.setImage(a((ITreeNode)paramIElement));
    else if ((paramIElement.getParent() instanceof ITreeNode))
      paramTreeItem.setImage(a((ITreeNode)paramIElement.getParent()));
    else if ((paramIElement.getParent() instanceof ISubFunction))
      paramTreeItem.setImage(ResourceTools.getImage("classsubfunction.icon"));
    else if ((paramIElement.getParent() instanceof ISubVariable))
      paramTreeItem.setImage(ResourceTools.getImage("classsubvariable.icon"));
    else if ((paramIElement.getParent() instanceof IFunctionObject))
      paramTreeItem.setImage(ResourceTools.getImage("classfunction.icon"));
    else if ((paramIElement.getParent() instanceof IVariableObject))
      paramTreeItem.setImage(ResourceTools.getImage("classvariable.icon"));
  }

  private void a(TreeItem paramTreeItem, TableModel paramTableModel)
  {
    paramTreeItem.setText(0, paramTableModel.getDisplayName());
    a(paramTreeItem, paramTableModel);
    paramTreeItem.setData(paramTableModel);
    List localList = paramTableModel.getChildrenList();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof FieldModel))
        continue;
      FieldModel localFieldModel = (FieldModel)localList.get(i);
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      localTreeItem.setData(localFieldModel);
      localTreeItem.setText(0, localFieldModel.getDisplayName());
      localTreeItem.setText(1, localFieldModel.getFieldName());
      localTreeItem.setText(2, localFieldModel.getValueType());
      a(localTreeItem, localFieldModel);
    }
  }

  protected GridLayout a(int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = paramInt;
    return localGridLayout;
  }

  protected String b(String paramString)
  {
    return ResourceTools.getMessage(paramString);
  }

  protected GridData a(int paramInt1, int paramInt2)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = paramInt1;
    localGridData.heightHint = paramInt2;
    return localGridData;
  }

  private void a()
  {
    c(null);
  }

  private void c(String paramString)
  {
    setErrorMessage(paramString);
    setPageComplete(paramString == null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.f.b
 * JD-Core Version:    0.6.0
 */