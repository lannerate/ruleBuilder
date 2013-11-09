package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.repository.l;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class s extends r
{
  private l[] a = null;
  private l b;
  private Text c;
  private String d = "";
  private BuilderManager e;
  private Tree f;

  public s(BuilderManager paramBuilderManager, IBusinessObject paramIBusinessObject, l[] paramArrayOfl)
  {
    super(paramBuilderManager.getShell());
    this.a = paramArrayOfl;
    this.e = paramBuilderManager;
    if (paramIBusinessObject != null)
      this.d = paramIBusinessObject.getDisplayName();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.PopupSelectDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite1.setLayout(localGridLayout);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(550, 350));
    Composite localComposite3 = new Composite(localComposite2, 0);
    localComposite3.setLayout(a(2));
    localComposite3.setLayoutData(a(500, 25));
    a(localComposite3).setText(a("input.PopupSelectDialog"));
    this.c = a(localComposite3, 2048, 400, 12);
    this.f = new com.flagleader.builder.widget.s().a(localComposite2, 67584);
    this.f.setLayoutData(new GridData(1808));
    this.f.setHeaderVisible(true);
    this.f.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.PopupSelectDialog");
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".PopupSelectDialog");
    Object localObject;
    for (i = 0; i < arrayOfString2.length; i++)
    {
      localObject = new TreeColumn(this.f, 8388608);
      ((TreeColumn)localObject).setText(arrayOfString2[i]);
      if (i == 0)
        ((TreeColumn)localObject).setWidth(400);
      else
        ((TreeColumn)localObject).setWidth(120);
    }
    this.f.setLayoutData(new GridData(1808));
    for (i = 0; i < this.a.length; i++)
    {
      localObject = new TreeItem(this.f, 0);
      ((TreeItem)localObject).setText(0, this.a[i].b());
      if ((this.a[i].e() instanceof ITreeNode))
        ((TreeItem)localObject).setImage(a((ITreeNode)this.a[i].e()));
      else if ((this.a[i].e() instanceof ISubFunction))
        ((TreeItem)localObject).setImage(ResourceTools.getImage("classsubfunction.icon"));
      else if ((this.a[i].e() instanceof ISubVariable))
        ((TreeItem)localObject).setImage(ResourceTools.getImage("classsubvariable.icon"));
      else if ((this.a[i].e() instanceof IFunctionObject))
        ((TreeItem)localObject).setImage(ResourceTools.getImage("classfunction.icon"));
      else if ((this.a[i].e() instanceof IVariableObject))
        ((TreeItem)localObject).setImage(ResourceTools.getImage("classvariable.icon"));
      if ((this.a[i].e() instanceof IBusinessObject))
        ((TreeItem)localObject).setText(1, ((IBusinessObject)this.a[i].e()).getValueName());
      if (this.a[i].c())
        a(this.a[i], (TreeItem)localObject);
      else
        ((TreeItem)localObject).setData(this.a[i]);
    }
    if ((this.d != null) && (this.d.length() > 0))
    {
      a(this.f.getItems(), this.d);
      this.c.setText(this.d);
      this.c.selectAll();
    }
    this.c.addKeyListener(new t(this));
    return (Control)localComposite1;
  }

  private void a(TreeItem[] paramArrayOfTreeItem, String paramString)
  {
    for (int i = paramArrayOfTreeItem.length - 1; i >= 0; i--)
      if (paramArrayOfTreeItem[i].getData() == null)
      {
        if (paramArrayOfTreeItem[i].getItemCount() > 0)
        {
          a(paramArrayOfTreeItem[i].getItems(), paramString);
          if (paramArrayOfTreeItem[i].getItemCount() != 0)
            continue;
          paramArrayOfTreeItem[i].dispose();
        }
        else
        {
          paramArrayOfTreeItem[i].dispose();
        }
      }
      else
      {
        if ((paramArrayOfTreeItem[i].getText(0).toLowerCase().startsWith(paramString.toLowerCase())) || (paramArrayOfTreeItem[i].getText(1).toLowerCase().startsWith(paramString.toLowerCase())))
          continue;
        paramArrayOfTreeItem[i].dispose();
      }
  }

  private void b()
  {
    this.f.forceFocus();
  }

  private void c()
  {
    this.f.forceFocus();
  }

  private Image a(ITreeNode paramITreeNode)
  {
    return ResourceTools.getIcon(paramITreeNode);
  }

  private void a(l paraml, TreeItem paramTreeItem)
  {
    l[] arrayOfl = paraml.d();
    for (int i = 0; i < arrayOfl.length; i++)
    {
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      localTreeItem.setText(0, arrayOfl[i].b());
      if ((arrayOfl[i].e() instanceof ITreeNode))
        localTreeItem.setImage(a((ITreeNode)arrayOfl[i].e()));
      else if ((arrayOfl[i].e() instanceof ISubFunction))
        localTreeItem.setImage(ResourceTools.getImage("classsubfunction.icon"));
      else if ((arrayOfl[i].e() instanceof ISubVariable))
        localTreeItem.setImage(ResourceTools.getImage("classsubvariable.icon"));
      else if ((arrayOfl[i].e() instanceof IFunctionObject))
        localTreeItem.setImage(ResourceTools.getImage("classfunction.icon"));
      else if ((arrayOfl[i].e() instanceof IVariableObject))
        localTreeItem.setImage(ResourceTools.getImage("classvariable.icon"));
      if ((arrayOfl[i].e() instanceof IBusinessObject))
        localTreeItem.setText(1, ((IBusinessObject)arrayOfl[i].e()).getValueName());
      if (arrayOfl[i].c())
        a(arrayOfl[i], localTreeItem);
      else
        localTreeItem.setData(arrayOfl[i]);
    }
    paramTreeItem.setExpanded(true);
  }

  protected void okPressed()
  {
    if (this.f.getSelectionCount() == 1)
    {
      TreeItem localTreeItem = this.f.getSelection()[0];
      if (localTreeItem.getData() != null)
      {
        this.b = ((l)localTreeItem.getData());
        super.okPressed();
        return;
      }
    }
    this.e.showError(a("empty.PopupSelectDialog"));
  }

  public l a()
  {
    return this.b;
  }

  public void a(l paraml)
  {
    this.b = paraml;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.s
 * JD-Core Version:    0.6.0
 */