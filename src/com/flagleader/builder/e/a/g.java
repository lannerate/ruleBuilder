package com.flagleader.builder.e.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.XmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class g extends WizardPage
{
  private Table b;
  private LinkedHashMap c = new LinkedHashMap();
  LinkedHashMap a = new LinkedHashMap();
  private TableItem d;
  private TableEditor e;
  private ArrayList f = new ArrayList();

  public g(k paramk)
  {
    super("AssignVariablePage3");
    setTitle(a("title.AssignVariablePage3"));
    setDescription(a("describe.AssignVariablePage3"));
  }

  public void createControl(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(1));
    localComposite.setLayoutData(a(550, 400));
    com.flagleader.builder.widget.i locali = new com.flagleader.builder.widget.i(false, true);
    this.b = locali.a(localComposite, ".AssignVariablePage3", 68352);
    this.e = new TableEditor(this.b);
    this.b.addMouseListener(new h(this));
    b();
    setControl(localComposite);
  }

  private void a(TableItem paramTableItem, int paramInt)
  {
    CCombo localCCombo = new CCombo(this.b, 8);
    String[] arrayOfString = new String[this.c.size()];
    this.f.clear();
    Iterator localIterator = this.c.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      this.f.add(localObject);
      arrayOfString[(i++)] = a(localObject);
    }
    localCCombo.setItems(arrayOfString);
    localCCombo.setText(paramTableItem.getText(paramInt));
    if (localCCombo.getItemCount() < 20)
      localCCombo.setVisibleItemCount(localCCombo.getItemCount());
    else
      localCCombo.setVisibleItemCount(20);
    this.e.horizontalAlignment = 16384;
    this.e.grabHorizontal = true;
    this.e.minimumWidth = 50;
    this.e.setEditor(localCCombo, paramTableItem, paramInt);
    localCCombo.addFocusListener(new i(this, localCCombo, paramTableItem));
    localCCombo.addTraverseListener(new j(this, localCCombo, paramTableItem));
    localCCombo.setFocus();
  }

  public void a(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      Object localObject = paramList.get(i);
      if (this.a.containsKey(localObject))
        continue;
      this.a.put(localObject, null);
    }
    b();
  }

  public void b(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      Object localObject = paramList.get(i);
      this.a.remove(localObject);
    }
    b();
  }

  private String a(Object paramObject)
  {
    if ((paramObject instanceof FieldModel))
      return ((FieldModel)paramObject).getShowDisplayName();
    if ((paramObject instanceof IVariableObject))
      return ((IVariableObject)paramObject).getShowDisplayName();
    if ((paramObject instanceof XmlNode))
      return ((XmlNode)paramObject).getShowDisplayName();
    return "";
  }

  private String b(Object paramObject)
  {
    if ((paramObject instanceof FieldModel))
      return ((FieldModel)paramObject).getDisplayName();
    if ((paramObject instanceof IVariableObject))
      return ((IVariableObject)paramObject).getDisplayName();
    if ((paramObject instanceof XmlNode))
      return ((XmlNode)paramObject).getDisplayName();
    return "";
  }

  private String c(Object paramObject)
  {
    if ((paramObject instanceof FieldModel))
      return ((FieldModel)paramObject).getFieldName();
    if ((paramObject instanceof IVariableObject))
      return ((IVariableObject)paramObject).getValueName();
    if ((paramObject instanceof XmlNode))
      return ((XmlNode)paramObject).getValueName();
    return "";
  }

  public boolean a(Object paramObject1, Object paramObject2)
  {
    return (b(paramObject1).equalsIgnoreCase(b(paramObject2))) || (c(paramObject1).equalsIgnoreCase(c(paramObject2)));
  }

  public void c(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      Object localObject1 = paramList.get(i);
      if (this.c.containsKey(localObject1))
        continue;
      Object localObject2 = null;
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        if ((this.a.get(localObject3) != null) || (!a(localObject3, localObject1)))
          continue;
        localObject2 = localObject3;
        this.a.put(localObject3, localObject1);
        break;
      }
      this.c.put(localObject1, localObject2);
    }
    b();
  }

  public void d(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      Object localObject1 = paramList.get(i);
      this.c.remove(localObject1);
      if (!this.a.containsValue(localObject1))
        continue;
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((this.a.get(localObject2) == null) || (!this.a.get(localObject2).equals(localObject1)))
          continue;
        this.a.put(localObject2, null);
      }
    }
    b();
  }

  public LinkedHashMap a()
  {
    return this.a;
  }

  private Image a(ITreeNode paramITreeNode)
  {
    return ResourceTools.getIcon(paramITreeNode);
  }

  private void a(TableItem paramTableItem, Object paramObject)
  {
  }

  private void b()
  {
    this.b.removeAll();
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      TableItem localTableItem = new TableItem(this.b, 0);
      if ((localObject1 instanceof FieldModel))
      {
        localTableItem.setText(0, ((FieldModel)localObject1).getShowDisplayName());
        localTableItem.setText(1, ((FieldModel)localObject1).getValueType());
        localTableItem.setText(2, ((FieldModel)localObject1).getValueName());
      }
      else if ((localObject1 instanceof IVariableObject))
      {
        localTableItem.setText(0, ((IVariableObject)localObject1).getShowDisplayName());
        localTableItem.setText(1, ((IVariableObject)localObject1).getValueType());
        localTableItem.setText(2, ((IVariableObject)localObject1).getValueName());
      }
      else if ((localObject1 instanceof XmlNode))
      {
        localTableItem.setText(0, ((XmlNode)localObject1).getShowDisplayName());
        localTableItem.setText(1, "string");
        localTableItem.setText(2, ((XmlNode)localObject1).getValueName());
      }
      if (this.a.get(localObject1) != null)
      {
        Object localObject2 = this.a.get(localObject1);
        if ((localObject2 instanceof FieldModel))
          localTableItem.setText(3, ((FieldModel)localObject2).getShowDisplayName());
        else if ((localObject2 instanceof IVariableObject))
          localTableItem.setText(3, ((IVariableObject)localObject2).getShowDisplayName());
        else if ((localObject2 instanceof XmlNode))
          localTableItem.setText(3, ((XmlNode)localObject2).getShowDisplayName());
      }
      localTableItem.setData(localObject1);
    }
  }

  private void c()
  {
    b(null);
  }

  private void b(String paramString)
  {
    setErrorMessage(paramString);
    setPageComplete(paramString == null);
  }

  protected GridLayout a(int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = paramInt;
    return localGridLayout;
  }

  protected String a(String paramString)
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

  private void a(Composite paramComposite, int paramInt)
  {
    Label localLabel = new Label(paramComposite, 259);
    GridData localGridData = new GridData(768);
    localGridData.horizontalSpan = paramInt;
    localLabel.setLayoutData(localGridData);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.a.g
 * JD-Core Version:    0.6.0
 */