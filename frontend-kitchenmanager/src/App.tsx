import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger
} from "@/components/ui/dialog";

import axios from "axios";
import { useEffect, useState } from "react";

interface FinalProductIngredient {
  id: number;
  name: string;
  quantity: number;
}

// Interface para o produto
interface Ingredient {
  id: number;
  name: string;
  unit: string;
  currentStock: number;
  price: number;
  supplier: string;
  finalProductIngredient: FinalProductIngredient[];
}

interface Product {
  id: number;
  name: string;
  price: number;
  finalProductIngredient: FinalProductIngredient[];
}

function App() {
 const [products, setProducts] = useState<Product[]>([])
 const [ingredients, setIngredients] = useState<Ingredient[]>([])

  useEffect(() => {
    axios.get("http://localhost:8080/products")
    .then(res => {
      setProducts(res.data)
      })

    axios.get("http://localhost:8080/ingredients")
    .then(res => {
      setIngredients(res.data)
    })
  }, [])


  console.log(products);
  return (
    <div className="p-5 ma flex gap-20">
      <Table>
        <TableCaption>Produtos</TableCaption>
        <TableHeader>
          <TableRow>
            <TableHead>ID</TableHead>
            <TableHead>Nome</TableHead>
            <TableHead>Preco</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          {products.map((product) => (
            <TableRow key={product.id}>
              <TableCell>{product.id}</TableCell>
              <Dialog>
                <DialogTrigger>
                  <TableCell>{product.name}</TableCell>
                </DialogTrigger>

                <DialogContent>
                  <DialogHeader>
                  <DialogTitle>{product.name}</DialogTitle>
                    <DialogDescription>Lista de Ingredientes do produto {product.name}</DialogDescription>
                  </DialogHeader>
                  <Table>
                    <TableHeader>
                      <TableHead>Ingrediente</TableHead>
                      <TableHead>Quantidade</TableHead>
                    </TableHeader>
                    <TableBody>
                      {product.finalProductIngredient.map((ingredient) => (
                      <TableRow>
                        <TableCell>{ingredient.name}</TableCell>
                        <TableCell>{ingredient.quantity}</TableCell>
                      </TableRow>
                      ))}
                    </TableBody>
                  </Table>
                  <DialogFooter>
                    <Button  type="submit">Sair</Button>
                  </DialogFooter>
                </DialogContent>


              </Dialog>
              <TableCell>{product.price}</TableCell>
            </TableRow>
          ))}

        </TableBody>
      </Table>

      <Table>
        <TableCaption>Ingredientes</TableCaption>
        <TableHeader>
          <TableRow>
            <TableHead>ID</TableHead>
            <TableHead>Nome</TableHead>
            <TableHead>Em stock</TableHead>
            <TableHead>Preco</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          {ingredients.map((ingredient) => (
            <TableRow key={ingredient.id}>
              <TableCell>{ingredient.id}</TableCell>
              <TableCell>{ingredient.name}</TableCell>
              <TableCell>{ingredient.currentStock + " " + ingredient.unit}</TableCell>
              <TableCell>{ingredient.price}</TableCell>
            </TableRow>
          ))}

        </TableBody>
      </Table>
    </div>
  )
}

export default App
