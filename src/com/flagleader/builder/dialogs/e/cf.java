package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class cf extends r
{
  private ArrayList a;
  private int b = -1;
  private List c = new ArrayList();
  private IVariableObject d;
  private Combo e;
  private String f = "";
  private BuilderManager g;
  private Table h;

  public cf(BuilderManager paramBuilderManager, Map paramMap, IRuleTree paramIRuleTree)
  {
    super(paramBuilderManager.getShell());
    this.g = paramBuilderManager;
    this.a = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IVariableObject))
        continue;
      this.a.add(localObject);
    }
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.VariableReplaceDialog"));
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
    localComposite3.setLayoutData(a(550, 25));
    a(localComposite3, a("variable.VariableReplaceDialog"));
    this.e = c(localComposite3);
    String[] arrayOfString1 = new String[this.a.size()];
    for (int i = 0; i < this.a.size(); i++)
    {
      if (!(this.a.get(i) instanceof IVariableObject))
        continue;
      arrayOfString1[i] = (((IVariableObject)this.a.get(i)).getDisplayName() + "\t\t" + ((IVariableObject)this.a.get(i)).getValueName());
    }
    if ((arrayOfString1 != null) && (arrayOfString1.length > 0))
      this.e.setItems(arrayOfString1);
    if (this.e.getItemCount() < 20)
      this.e.setVisibleItemCount(this.e.getItemCount());
    else
      this.e.setVisibleItemCount(20);
    i locali = new i(false, true);
    this.h = locali.a(localComposite2, 67584);
    this.h.setLayoutData(new GridData(1808));
    this.h.setHeaderVisible(true);
    this.h.setLinesVisible(true);
    String[] arrayOfString2 = ResourceTools.getStringArray("columns.VariableReplaceDialog");
    while (this.h.getColumnCount() > 0)
      this.h.getColumn(0).dispose();
    String[] arrayOfString3 = new String[arrayOfString2.length];
    for (int j = 0; j < arrayOfString2.length; j++)
      arrayOfString3[j] = ResourceTools.getMessage(arrayOfString2[j] + ".VariableReplaceDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    String[] arrayOfString4 = new String[arrayOfString3.length];
    for (int k = 0; k < arrayOfString3.length; k++)
    {
      arrayOfString4[k] = "string";
      if (k == 0)
        arrayOfInt[k] = 200;
      else
        arrayOfInt[k] = 100;
    }
    locali.a(arrayOfString3, arrayOfInt, arrayOfString4);
    this.h.setLayoutData(new GridData(1808));
    e();
    this.e.addSelectionListener(new cg(this));
    return localComposite1;
  }

  private Combo c(Composite paramComposite)
  {
    Combo localCombo = new Combo(paramComposite, 2048);
    GridData localGridData = new GridData();
    localGridData.widthHint = 450;
    localCombo.setLayoutData(localGridData);
    return localCombo;
  }

  private void a(TableItem[] paramArrayOfTableItem, int paramInt)
  {
    for (int i = paramArrayOfTableItem.length - 1; i >= 0; i--)
      if (paramArrayOfTableItem[i].getData() == null)
      {
        paramArrayOfTableItem[i].dispose();
      }
      else
      {
        if (((IVariableObject)paramArrayOfTableItem[i].getData()).getJavaType().b(((IVariableObject)this.a.get(paramInt)).getValueType()))
          continue;
        paramArrayOfTableItem[i].dispose();
      }
  }

  private void c()
  {
    this.h.forceFocus();
  }

  private void d()
  {
    this.h.forceFocus();
  }

  private Image a(ITreeNode paramITreeNode)
  {
    return ResourceTools.getIcon(paramITreeNode);
  }

  private void e()
  {
    for (int i = 0; i < this.c.size(); i++)
    {
      if (!(this.c.get(i) instanceof IVariableObject))
        continue;
      IVariableObject localIVariableObject = (IVariableObject)this.c.get(i);
      TableItem localTableItem = new TableItem(this.h, 0);
      localTableItem.setText(0, localIVariableObject.getDisplayName());
      if ((localIVariableObject.getParent() instanceof ITreeNode))
        localTableItem.setImage(a((ITreeNode)localIVariableObject.getParent()));
      else if ((localIVariableObject.getParent() instanceof ISubFunction))
        localTableItem.setImage(ResourceTools.getImage("classsubfunction.icon"));
      else if ((localIVariableObject.getParent() instanceof ISubVariable))
        localTableItem.setImage(ResourceTools.getImage("classsubvariable.icon"));
      else if ((localIVariableObject.getParent() instanceof IFunctionObject))
        localTableItem.setImage(ResourceTools.getImage("classfunction.icon"));
      else if ((localIVariableObject.getParent() instanceof IVariableObject))
        localTableItem.setImage(ResourceTools.getImage("classvariable.icon"));
      localTableItem.setText(1, localIVariableObject.getParent().getDisplayName());
      localTableItem.setText(2, localIVariableObject.getValueType());
      localTableItem.setText(3, localIVariableObject.getValueName());
      localTableItem.setData(localIVariableObject);
    }
  }

  protected void okPressed()
  {
    if ((this.h.getSelectionCount() == 1) && (this.b >= 0))
    {
      TableItem localTableItem = this.h.getSelection()[0];
      if (localTableItem.getData() != null)
      {
        this.d = ((IVariableObject)localTableItem.getData());
        super.okPressed();
        return;
      }
    }
    this.g.showError(a("empty.VariableReplaceDialog"));
  }

  public IVariableObject a()
  {
    return this.d;
  }

  public IVariableObject b()
  {
    return (IVariableObject)this.a.get(this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.cf
 * JD-Core Version:    0.6.0
 */